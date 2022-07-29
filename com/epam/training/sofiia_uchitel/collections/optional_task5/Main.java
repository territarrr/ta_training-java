package com.epam.training.sofiia_uchitel.collections.optional_task5;

import com.epam.training.sofiia_uchitel.collections.main_task.Ingredient;

import java.util.*;

//Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите целые числа, которые добавятся в список, через пробел:");
        Scanner scanner = new Scanner(System.in);
        String[] inputStrings = scanner.nextLine().split(" ");
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        try {
            for (String string : inputStrings) {
                inputNumbers.add(Integer.parseInt(string));
            }
        } catch (NumberFormatException e) {
            System.out.println("Разрешается вводить только целые числа");
        }
        Collections.sort(inputNumbers, Collections.reverseOrder());
        System.out.println("Список, у которого в конце отрицательные элементы, а в начале положительные: ");
        System.out.println(inputNumbers);
    }
}
