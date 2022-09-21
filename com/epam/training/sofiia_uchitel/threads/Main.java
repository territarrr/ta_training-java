package com.epam.training.sofiia_uchitel.threads;

// Разработать консольное многопоточное приложение. Использовать возможности, предоставляемые пакетом java.util.concurrent.
// Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
// Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
public class Main {
    private static final int MAX_TIME = 10;
    private static final int CARS_COUNT = 5;

    public static void main(String[] args) {
        Parking parking = new Parking(3);
        for (int i = 1; i <= CARS_COUNT; i++) {
            Car car = new Car("car" + i, (int) (Math.random() * (MAX_TIME)) + 1, (int) (Math.random() * MAX_TIME) + 1);
            new Thread(new CarThread(parking, car)).start();
        }
    }
}
