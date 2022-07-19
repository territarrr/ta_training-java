package com.epam.training.sofiia_uchitel.fundamentals.main_task;

import java.util.Scanner;

//1. Приветствовать любого пользователя при вводе его имени через командную строку.
public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String userName = scanner.nextLine();
        System.out.printf("Hello, %s!", userName);
    }
}
