package com.epam.training.sofiia_uchitel.classes.main_task;

import java.time.LocalDate;
import java.util.Arrays;

enum Binding {
    HARDCOVER("Tвердый переплет"),
    SOFTCOVER("Мягкий переплет"),
    SADDLESTITCH("Брошюровка металлической скобкой"),
    PUR("Клеевое швейное скрепление");
    private String description;

    private Binding(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }
}

public class Book {
    private static final int MIN_PUBLISHING_YEAR = 1900; //переменная для "разумного" ограничений минимального года публикации
    private static int counterIds = 0;
    private final int id = counterIds++;
    private String name;
    private String[] authors;
    private String publisher;
    private int yearOfPublishing;
    private int pagesCount;
    private double price;
    private Binding bindingType;

    //Выполняю условие: "В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов."
    public Book(String name, String[] authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(String name, String[] authors, String publisher, int yearOfPublishing, int pagesCount, double price, Binding bindingType) {
        setName(name);
        setAuthors(authors);
        setPublisher(publisher);
        setYearOfPublishing(yearOfPublishing);
        setPagesCount(pagesCount);
        setPrice(price);
        setBindingType(bindingType);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }


    public void setYearOfPublishing(int yearOfPublishing) {
        if (yearOfPublishing <= LocalDate.now().getYear() && yearOfPublishing>MIN_PUBLISHING_YEAR) {
            this.yearOfPublishing = yearOfPublishing;
        } else {
            if (yearOfPublishing > LocalDate.now().getYear())
                throw new RuntimeException("Год публикации не может быть больше текущего " + LocalDate.now().getYear() + " года");
            if(yearOfPublishing<MIN_PUBLISHING_YEAR)
                throw new RuntimeException("Год публикации не может быть меньше " + MIN_PUBLISHING_YEAR + " года");

        }
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        if (pagesCount > 0) {
            this.pagesCount = pagesCount;
        } else {
            throw new RuntimeException("Количество страниц должно быть больше 0");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new RuntimeException("Цена должна быть больше 0");
        }
    }

    public Binding getBindingType() {
        return bindingType;
    }

    public void setBindingType(Binding bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "id:" + id +
                ", Название: '" + name + '\'' +
                ", Авторы: " + Arrays.toString(authors) +
                ", Издательство: " + publisher +
                ", Год издания: " + yearOfPublishing +
                ", Количество страниц:" + pagesCount +
                ", Цена: " + price +
                ", Тип переплета: " + bindingType.getDescription() +
                "}";
    }
}
