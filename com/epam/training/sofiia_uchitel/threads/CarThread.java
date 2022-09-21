package com.epam.training.sofiia_uchitel.threads;

import java.util.concurrent.TimeUnit;

import static com.epam.training.sofiia_uchitel.threads.utils.Utils.synchronizedPtintlnf;

public class CarThread extends Thread {
    private Parking parking;
    private Car car;

    CarThread(Parking parking, Car car) {
        this.parking = parking;
        this.car = car;
    }

    @Override
    public void run() {
        try {
            if (!parking.hasFreePlaces()) {
                synchronizedPtintlnf("На парковке нет свободных мест. Машина с номером %s встает в очередь. Время ожидания свободного места на более %s минут.", car.getNumber(), car.getMaxWaitingTime());
            }
            if (parking.carSemaphore.tryAcquire(car.getMaxWaitingTime(), TimeUnit.SECONDS)) {
                int parkingPlace = parking.letCarIn(car);
                synchronizedPtintlnf("Машина с номером %s припарковалась на месте #%s. Машина с номером %s будет занимать место %d минут. Свободных мест на стоянке: %d", car.getNumber(), parkingPlace, car.getNumber(), car.getMaxParkingTime(), parking.getCountOfFreePlaces());

                TimeUnit.SECONDS.sleep(car.getMaxParkingTime());

                parking.letCarOut(car);
                synchronizedPtintlnf("Машина с номером %s освободила место на стоянке. Свободных мест на стоянке: %d", car.getNumber(), parking.getCountOfFreePlaces());

                parking.carSemaphore.release();
                sleep(500);
            } else {
                synchronizedPtintlnf("Максимальное время ожидания для машины с номером %s превышено. Машина покидает очередь", car.getNumber());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
