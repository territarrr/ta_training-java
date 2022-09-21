package com.epam.training.sofiia_uchitel.threads;

public class Car {
    private final String number;
    private final int maxWaitingTime;
    private final int maxParkingTime;

    public Car(String number, int maxWaitingTime, int maxParkingTime) {
        this.number = number;
        this.maxWaitingTime = maxWaitingTime;
        this.maxParkingTime = maxParkingTime;
    }

    public String getNumber() {
        return number;
    }

    public int getMaxWaitingTime() {
        return maxWaitingTime;
    }

    public int getMaxParkingTime() {
        return maxParkingTime;
    }
}
