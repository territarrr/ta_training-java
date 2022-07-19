package com.epam.training.sofiia_uchitel.fundamentals.main_task;

import java.util.Scanner;

//5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
public class Month {
    public static String getMonthName(int month) {
        String[] arrayMonths = {"Январь", "Феваль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Hоябрь", "Декабрь"};
        try {
            return arrayMonths[month - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Месяца с таким порядковым номером не существует!";
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите порядковый номер месяца от 1 до 12: ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Неверный ввод. Введенное число должно быть целым числом в диапазоне от 1 до 12. Повторите ввод:");
            month = scanner.nextInt();
        }
        System.out.println(getMonthName(month));
    }
}
