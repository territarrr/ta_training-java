package com.epam.training.sofiia_uchitel.threads;

public class Car {
    private final String carNumber;
    private final int maxWaitngTimeInMinutes;
    private final int maxParkingTimeInMinutes;

    public Car(String carNumber, int maxWaitngTimeInMinutes, int maxParkingTimeInMinutes) {
        this.carNumber = carNumber;
        this.maxWaitngTimeInMinutes = maxWaitngTimeInMinutes;
        this.maxParkingTimeInMinutes = maxParkingTimeInMinutes;
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
}
