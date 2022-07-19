package com.epam.training.sofiia_uchitel.fundamentals.main_task;

import java.util.Scanner;

//2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
public class ReverseArgs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для разворота:");
        StringBuilder inputArgs = new StringBuilder(scanner.nextLine());
        System.out.println(inputArgs.reverse());
    }
}
