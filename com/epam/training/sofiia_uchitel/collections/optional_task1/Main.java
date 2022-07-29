package com.epam.training.sofiia_uchitel.collections.optional_task1;

import java.io.*;
import java.util.ArrayDeque;

//Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayDeque<String> fileContent = new ArrayDeque<>();
        try (
                FileReader reader = new FileReader("com/epam/training/sofiia_uchitel/collections/optional_task1/inputfile.txt");
                BufferedReader br = new BufferedReader(reader);
                FileWriter writer = new FileWriter("com/epam/training/sofiia_uchitel/collections/optional_task1/output.txt");
                BufferedWriter bw = new BufferedWriter(writer)
        ) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                fileContent.push(currentLine);
            }

            while (!fileContent.isEmpty()) {
                bw.write(fileContent.pop() + "\n");
            }
            System.out.println("Строки из файла inputfile.txt записаны в обратном порядке в файл output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
