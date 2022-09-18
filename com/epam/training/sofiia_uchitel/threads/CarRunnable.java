package com.epam.training.sofiia_uchitel.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CarRunnable implements Runnable {
    private final Parking parking;
    private final Car car;

    public CarRunnable(Parking parking, Car car) {
        this.parking = parking;
        this.car = car;
        new Thread(this).start();
    }

    @Override
    public void run() {
        if (!this.parking.hasFreePlaces()) {
            System.out.printf("На парковке нет свободных мест. Машина с номером %s встает в очередь. Время ожидания свободного места на более %s минут.\n", car.getCarNumber(), car.getMaxWaitngTimeInMinutes());
        }
        try {
            if (this.parking.carSemaphore.tryAcquire(car.getMaxWaitngTimeInMinutes(), TimeUnit.SECONDS)) {
                try {
                    int parkingPlace = parking.letCarIn(car);
                    System.out.printf("Машина с номером %s припарковалась на месте #%s. \n", car.getCarNumber(), parkingPlace);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.printf("Машина с номером %s будет занимать место %d минут.", car.getCarNumber(), car.getMaxParkingTimeInMinutes());
                System.out.printf("Свободных мест на стоянке: %d\n", parking.getCountOfFreePlaces());

                TimeUnit.SECONDS.sleep(car.getMaxParkingTimeInMinutes());

                try {
                    parking.letCarOut(car);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.printf("Машина с номером %s освободила место на стоянке. ", car.getCarNumber());
                System.out.printf("Свободных мест на стоянке: %d\n", parking.getCountOfFreePlaces());

                parking.carSemaphore.release();
            } else {
                System.out.printf("Максимальное время ожидания для машины с номером %s превышено. Машина покидает очередь\n", car.getCarNumber());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
