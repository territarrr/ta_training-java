package com.epam.training.sofiia_uchitel.fundamentals.optional_task1;

import java.util.Arrays;
import java.util.Scanner;

/*
Задание. Ввести n чисел с консоли.

Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
Вывести числа в порядке возрастания (убывания) значений их длины.
Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();
        while (n < 1) {
            System.out.println("Неверный ввод. Количество чисел для операций с ними должно быть больше 0. Повторите ввод:");
            n = scanner.nextInt();
        }

        int[] numbers = new int[n];

        System.out.printf("Введите последовательность из %d целых чисел: \n", n);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        NumbersArray numbersArray = new NumbersArray(numbers);

        System.out.printf("Самое короткое число - %d длиной %d.\n", numbersArray.getMinLengthNumber(), String.valueOf(numbersArray.getMinLengthNumber()).length());
        System.out.printf("Самое длинное число - %d длиной %d.\n", numbersArray.getMaxLengthNumbers(), String.valueOf(numbersArray.getMaxLengthNumbers()).length());


        System.out.println("\nМассив чисел в порядке возрастания значений их длин:");
        System.out.println(Arrays.toString(numbersArray.sortByMaxLength()));

        System.out.println("Массив чисел в порядке убывания значений их длин:");
        System.out.println(Arrays.toString(numbersArray.reverse(numbersArray.sortByMaxLength())));

        System.out.printf("\nЧисла массива, у которых длина меньше среднего (%f) значения длины чисел исходного массива:\n", numbersArray.getAverageNumberLength());
        numbersArray.printArrayElementsAndLength(numbersArray.getNumbersLengthLessThanAverage());

        System.out.printf("\nЧисла массива, у которых длина больше среднего (%f) значения длины чисел исходного массива:\n", numbersArray.getAverageNumberLength());
        numbersArray.printArrayElementsAndLength(numbersArray.getNumbersLengthMoreThanAverage());

        System.out.printf("\nЧисло, в котором количество различных цифр минимально: %d\n", numbersArray.getNumberWithMinimumUniqueDigits());

        System.out.printf("\nКоличество чисел, содержащих только четные цифр: %d\n", numbersArray.getNumbersWithEvenDigits().length);

        System.out.printf("\nКоличество чисел, содержащих равное количество четных и нечетных цифр: %d\n", numbersArray.getNumbersWithEqualsCountEvenAndNotEvenDigits().length);

        System.out.println("\nЧисло, цифры в котором идут в строгом порядке возрастания: " + numbersArray.getNumberWithAscendingDigits());

        System.out.println("\nЧисло, состоящее только из различных цифр: " + numbersArray.getNumberWithOnlyUniqueDigits());
    }
}
