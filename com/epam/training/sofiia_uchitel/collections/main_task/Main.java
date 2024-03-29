package com.epam.training.sofiia_uchitel.collections.main_task;

import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;
import com.epam.training.sofiia_uchitel.collections.main_task.vеgetables.Allium;
import com.epam.training.sofiia_uchitel.collections.main_task.vеgetables.Marrow;
import com.epam.training.sofiia_uchitel.collections.main_task.vеgetables.Root;

import java.util.Scanner;


// Создать консольное приложение, удовлетворяющее следующим требованиям:
//Каждый класс должен иметь отражающее смысл название и информативный состав.
//Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
//Наследование должно применяться только тогда, когда это имеет смысл.
//При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//Классы должны быть грамотно разложены по пакетам
//Консольное меню должно быть минимальным.
//Для хранения параметров инициализации можно использовать файлы.
//
// Шеф-повар. Определить иерархию овощей.
// Сделать салат. Подсчитать калорийность.
// Провести сортировку овощей для салата на основе одного из параметров.
// Найти овощи в салате, соответствующие заданному диапазону калорийности.

public class Main {
    public static void main(String[] args) throws SaladException {
        Salad salad = new Salad("Salathuiat");
        salad.addIngredient(new Ingredient(new Root("Морковь", true, 32, 1.3, 0.29, 6.9, false), 400));
        salad.addIngredient(new Ingredient(new Allium("Лук", false, 47, 1.4, 0, 10.4, false, true), 222));
        salad.addIngredient(new Ingredient(new Marrow("Тыква", false, 28, 1.3, 0.3, 7.7, false), 345));
        System.out.printf("\nВывод полученного салата:\n%s", salad);
        System.out.printf("\nКоличество калорий в салате: %f\n", salad.getCalories());
        System.out.printf("\nОвощи салата, отсортированные по жирам по возрастанию (без учета веса в салате): %s\n", salad.getIngredientsByFats());
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nБудет произведен поиск овощей в салате, соответствующих заданному диапазону калорийности.");
        System.out.println("Введите начальное значение диапазона калорий: ");
        double startCalorie = scanner.nextDouble();
        System.out.println("Введите конечное значение диапазона калорий: ");
        double endCalorie = scanner.nextDouble();
        System.out.printf("Овощи в салате, соответствующие диапазону калорий [%f, %f]:\n %s", startCalorie, endCalorie, salad.getIngredientsByCaloriesInRange(startCalorie, endCalorie));
    }
}
