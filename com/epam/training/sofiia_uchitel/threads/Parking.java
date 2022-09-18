package com.epam.training.sofiia_uchitel.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Parking {
    private final int countOfPlaces;
    public final Semaphore carSemaphore;
    private final List<Car> places;

    public Parking(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
        carSemaphore = new Semaphore(countOfPlaces, false);
        places = new ArrayList<>(countOfPlaces);
        for (int i = 0; i < countOfPlaces; i++) {
            places.add(null);
        }
    }

    public synchronized int getCountOfFreePlaces() {
        int freePlaces = 0;
        for (Car place : places) {
            if (place == null) {
                freePlaces++;
            }
        }
        return freePlaces;
    }

    public synchronized boolean hasFreePlaces() {
        return places.contains(null);
    }

    public synchronized int letCarIn(Car car) {
        for (int i = 0; i < countOfPlaces; i++) {
            if (places.get(i) == null) {
                places.set(i, car);
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void letCarOut(Car car) {
        for (int i = 0; i < countOfPlaces; i++) {
            if (places.get(i) == car) {
                places.set(i, null);
            }
        }
    }
}
