package com.epam.training.sofiia_uchitel.collections.optional_task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Занести стихотворение в список. (Беру из файла)Провести сортировку по возрастанию длин строк.
public class Main {
    public static class PoemByLinesLengthComporator implements Comparator<String> {
        @Override
        public int compare(String line1, String line2) {
            return line1.length() - line2.length();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> poemByLine = new ArrayList<>();
        try (
                FileReader reader = new FileReader("com/epam/training/sofiia_uchitel/collections/optional_task4/inputfile.txt");
                BufferedReader br = new BufferedReader(reader)
        ) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                poemByLine.add(currentLine);
            }
            System.out.println("\nИсходное стихотворение с количеством символов: ");
            printCollection(poemByLine);
            System.out.println("\nОтсортированное по количеству символов в строке стихотворение с количеством символов: ");
            Collections.sort(poemByLine, new PoemByLinesLengthComporator());
            printCollection(poemByLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printCollection(ArrayList<String> collection) {
        for (String str : collection) {
            System.out.println(str + " (Количество символов строки: " + str.length() + ")");
        }
    }
}
