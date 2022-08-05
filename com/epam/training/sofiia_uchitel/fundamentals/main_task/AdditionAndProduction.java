package com.epam.training.sofiia_uchitel.fundamentals.main_task;

import java.util.Scanner;

//4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
public class AdditionAndProduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое целое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите второе целое число: ");
        int b = scanner.nextInt();
        System.out.printf("%d + %d = %d \n", a, b, addition(a, b));
        System.out.printf("%d * %d = %d \n", a, b, production(a, b));
    }

    private static long addition(int a, int b) {
        return (long) a + b;
    }

    private static long production(int a, int b) {
        return (long) a * b;
    }
}
