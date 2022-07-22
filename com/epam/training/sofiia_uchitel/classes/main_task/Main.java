package com.epam.training.sofiia_uchitel.classes.main_task;

import java.util.List;
import java.util.Scanner;

/*Создать классы, спецификации которых приведены ниже.
 Определить конструкторы и методы setТип(), getТип(), toString().
 Определить дополнительно методы в классе, создающем массив объектов.
 Задать критерий выбора данных и вывести эти данные на консоль.
 В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
Создать массив объектов. Вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Мастер и Маргарита", new String[]{"Михаил Булгаков"}, "Азбука", 2017, 480, 567.20, Binding.HARDCOVER));
        library.addBook(new Book("Благие знамения", new String[]{"Терри Пратчетт", "Нил Гейман"}, "Эксмо", 2021, 480, 320, Binding.HARDCOVER));
        library.addBook(new Book("Мизери", new String[]{"Стивен Кинг"}, "АСТ", 2017, 416, 273, Binding.SOFTCOVER));
        library.addBook(new Book("Американские боги", new String[]{"Нил Гейман"}, "Росмэн", 2019, 704, 671, Binding.SADDLESTITCH));
        library.addBook(new Book("Цвет волшебства", new String[]{"Терри Пратчетт"}, "Эксмо", 2022, 329, 549.90, Binding.PUR));
        library.addBook(new Book("Черный дом", new String[]{"Страуб Питер", "Стивен Кинг"}, "АСТ", 2016, 832, 381.20, Binding.SADDLESTITCH));
        library.addBook(new Book("Снеговик", new String[]{"Несбе Ю"}, "Иностранка", 2021, 644, 266, Binding.PUR));
        library.addBook(new Book("Темная Башня", new String[]{"Стивен Кинг"}, "АСТ", 2011, 623, 500, Binding.PUR));
        System.out.println("Все книги:");
        System.out.println(library);
        System.out.println("Введите автора:");
        Scanner scanner = new Scanner(System.in);
        String author = scanner.nextLine();
        System.out.printf("Поиск книг по автору %s:\n", author);
        System.out.println(library.findBooksByAuthor(author).toString());
        System.out.println("Введите издательство:");
        String publisher = scanner.nextLine();
        System.out.printf("Поиск книг по издалельству %s:\n", publisher);
        System.out.println(library.findBooksByPublisher(publisher).toString());
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        System.out.printf("Поиск книг изданных после %d года:\n", year);
        System.out.println(library.findBooksPublishedAfterYear(year).toString());
    }
}
