package com.epam.training.sofiia_uchitel.threads;

public class Main {
    public static void main(String[] args) {
        //Для наглядности все машины мтоят в очереди или занимают парковочное место от 1 до 3 минут
        final int MAX_WAIT_AND_PARKING_TIME_IN_MINUTES = 3;
        Parking carParking = new Parking(3);
        for (int i = 1; i <= 10; i++) {
            CarThread car = new CarThread("car" + i, carParking,(int) (Math.random() * (MAX_WAIT_AND_PARKING_TIME_IN_MINUTES)) + 1, (int) (Math.random() * MAX_WAIT_AND_PARKING_TIME_IN_MINUTES) + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
