package com.epam.training.sofiia_uchitel.classes.main_task;

import java.util.Arrays;

public class Library {
    private Book[] books;

    //Выполняю условие: "В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов."
    public Library() {
        books = new Book[0];
    }

    public Library(Book book) {
        this.books = new Book[]{book};
    }

    public Library(Book[] books) {
        this.books = books;
    }

    //Добавление новой книги в библиотеку
    public void addBook(Book book) {
        books = Arrays.copyOf(books, books.length + 1, Book[].class);
        books[books.length - 1] = book;
    }

    //Поиск списка книг заданного автора
    public Library findBooksByAuthor(String author) {
        Library authorsBooks = new Library();
        for (Book book : books) {
            for (String bookAuthor : book.getAuthors()) {
                if (bookAuthor.equals(author)) {
                    authorsBooks.addBook(book);
                    break;
                }
            }
        }
        return authorsBooks;
    }

    //Поиск списка книг, выпущенных заданным издательство
    public Library findBooksByPublisher(String publisher) {
        Library publishersBooks = new Library();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                publishersBooks.addBook(book);
            }
        }
        return publishersBooks;
    }

    //Поиск списка книг, выпущенных после заданного года.
    public Library findBooksPublishedAfterYear(int year) {
        Library publishedAfterYearBooks = new Library();
        for (Book book : books) {
            if (book.getYearOfPublishing() > year){
                publishedAfterYearBooks.addBook(book);
            }
        }
        return publishedAfterYearBooks;
    }

    @Override
    public String toString() {
        if (books.length>0) {
            return "Library{" +
                    "books=" + Arrays.toString(books) +
                    "\n}";
        } else {
            return "Значения отсутствуют!";
        }
    }
}
