package com.epam.training.sofiia_uchitel.threads.utils;

public class Utils {
    public static void synchronizedPtintlnf(String s, Object... args) {
        synchronized (System.out) {
            System.out.printf(s + "\n", args);
        }
    }
}
