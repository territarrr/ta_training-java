package com.epam.training.sofiia_uchitel.fundamentals.main_task;

import java.util.Random;
import java.util.Scanner;

//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class GenerateRandomNumbers {
    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    public static void printlnArray(int[] array) {
        for (int item : array) {
            System.out.println(item + " ");
        }
    }

    public static int[] generateIntArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел для генерации:");
        Integer countOfNumbers = scanner.nextInt();
        int[] intArray = generateIntArray(countOfNumbers);
        System.out.printf("Вывод %d чисел в одну строку:\n", countOfNumbers);
        printArray(intArray);
        System.out.printf("Вывод %d чисел c переходом на новую строку:\n", countOfNumbers);
        printlnArray(intArray);
    }

}
