package com.epam.training.sofiia_uchitel.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CarThread implements Runnable {
    private final ReentrantLock locker;
    private final String carNumber;
    private final int maxWaitngTimeInMinutes;
    private final int maxParkingTimeInMinutes;
    private final Parking parking;

    public CarThread(String id, Parking parking, int maxWaitngTimeInMinutes, int maxParkingTimeInMinutes) {
        this.carNumber = id;
        this.parking = parking;
        this.maxWaitngTimeInMinutes = maxWaitngTimeInMinutes;
        this.maxParkingTimeInMinutes = maxParkingTimeInMinutes;
        locker = new ReentrantLock();
        new Thread(this).start();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getMaxWaitngTimeInMinutes() {
        return maxWaitngTimeInMinutes;
    }

    public int getMaxParkingTimeInMinutes() {
        return maxParkingTimeInMinutes;
    }

    @Override
    public void run() {
        if (!this.parking.hasFreePlaces()) {
            System.out.printf("На парковке нет свободных мест. Машина с номером %s встает в очередь. Время ожидания свободного места на более %s минут.\n", carNumber, maxWaitngTimeInMinutes);
        }
        try {
            if (this.parking.carSemaphore.tryAcquire(maxWaitngTimeInMinutes, TimeUnit.MINUTES)) {
                locker.lock();
                try {
                    int parkingPlace = parking.letCarIn(this);
                    System.out.printf("Машина с номером %s припарковалась на месте #%s. \n", carNumber, parkingPlace);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    locker.unlock();
                }
                System.out.printf("Машина с номером %s будет занимать место %d минут.", carNumber, maxParkingTimeInMinutes);
                System.out.printf("Свободных мест на стоянке: %d\n", parking.getCountOfFreePlaces());

                TimeUnit.MINUTES.sleep(maxParkingTimeInMinutes);

                locker.lock();
                try {
                    parking.letCarOut(this);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    locker.unlock();
                }
                System.out.printf("Машина с номером %s освободила место на стоянке. ", carNumber);
                System.out.printf("Свободных мест на стоянке: %d\n", parking.getCountOfFreePlaces());

                parking.carSemaphore.release();
            } else {
                System.out.printf("Максимальное время ожидания для машины с номером %s превышено. Машина покидает очередь\n", carNumber);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
