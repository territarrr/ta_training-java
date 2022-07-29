package com.epam.training.sofiia_uchitel.collections.optional_task6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();

        try (
                FileReader reader = new FileReader("com/epam/training/sofiia_uchitel/collections/optional_task6/inputfile.txt");
                BufferedReader br = new BufferedReader(reader)
        ) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                fileContent.add(currentLine);
            }
            System.out.println("\nИсходный текст по строкам: ");
            printCollection(fileContent);
            Collections.sort(fileContent);
            System.out.println("\nОтсортированный методом sort из класса Collection текст по строкам: ");
            printCollection(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printCollection(ArrayList<String> collection) {
        for (String str : collection) {
            System.out.println(str);
        }
    }
}
