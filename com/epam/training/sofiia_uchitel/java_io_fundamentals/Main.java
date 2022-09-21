package com.epam.training.sofiia_uchitel.java_io_fundamentals;

import com.epam.training.sofiia_uchitel.java_io_fundamentals.utils.FileUtils;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь:");
        String inputPath = scanner.nextLine();
        File fileByInputPath = new File(inputPath);
        while (!fileByInputPath.exists()) {
            System.out.println("Указаный путь не соответствует файлу или папке. Введите корректный путь: ");
            inputPath = scanner.nextLine();
            fileByInputPath = new File(inputPath);
        }

        FileUtils.analyseFileStructure(fileByInputPath, inputPath);
    }
}
