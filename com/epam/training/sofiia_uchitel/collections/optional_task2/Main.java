package com.epam.training.sofiia_uchitel.collections.optional_task2;

import java.util.ArrayDeque;
import java.util.Scanner;


//Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> inputNumberDigits = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int inputNumber = scanner.nextInt();
        scanner.close();
        boolean signed = false;
        if (inputNumber < 0) {
            inputNumber *= -1;
            signed = true;
        }
        while (inputNumber > 0) {
            inputNumberDigits.add(inputNumber % 10);
            inputNumber /= 10;
        }
        String outputString;
        if (signed)
            outputString = "-";
        else
            outputString = "";
        while (!inputNumberDigits.isEmpty()) {
            outputString += inputNumberDigits.pop();
        }
        int outputNumber = Integer.valueOf(outputString);
        System.out.printf("Число с цифрами в обратном порядке: %d", outputNumber);
    }
}
