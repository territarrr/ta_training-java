package com.epam.training.sofiia_uchitel.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Parking {
    private final int countOfPlaces;
    public final Semaphore carSemaphore;
    private final Map<Integer, Car> occupiedPlaces = new HashMap<>();

    public Parking(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
        carSemaphore = new Semaphore(countOfPlaces, true);
    }

    public synchronized int getCountOfFreePlaces() {
        return countOfPlaces - occupiedPlaces.size();
    }

    public synchronized boolean hasFreePlaces() {
        return getCountOfFreePlaces() > 0;
    }

    public synchronized int letCarIn(Car car) {
        for (int i = 0; i < countOfPlaces; i++) {
            if (!occupiedPlaces.containsKey(i)) {
                occupiedPlaces.put(i, car);
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void letCarOut(Car car) {
        occupiedPlaces.values().remove(car);
    }
}
