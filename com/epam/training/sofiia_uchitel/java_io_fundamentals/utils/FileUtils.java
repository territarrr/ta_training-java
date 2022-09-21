package com.epam.training.sofiia_uchitel.java_io_fundamentals.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void analyseFileStructure(File path, String inputPath) {
        if (path.isDirectory()) {
            File outputFile = new File("/Users/sofiiauchitel/IdeaProjects/ta_training-java/com/epam/training/sofiia_uchitel/java_io_fundamentals/output.txt");
            try (FileWriter writer = new FileWriter(outputFile)) {
                FileUtils.printTree(new File(inputPath), "", writer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Структура по типу tree записана в файл output.txt");
        } else {
            List<String> files = readFile(path);
            System.out.println("Файл " + path.getName() + " прочитан.");
            int countDirs = FileUtils.countDirs(files);
            System.out.printf("Количество папок в %s: %d\n", path.getName(), countDirs);
            System.out.printf("Количество файлов в %s: %d\n", path.getName(), files.size() - countDirs);
            System.out.printf("Среднее количество файлов в папках в %s: %f\n", path.getName(), FileUtils.getAverageFileInDirsCount(files));
            System.out.printf("Средняя длина названия файла в %s: %f\n", path.getName(), FileUtils.getAverageFileNameLength(files));
        }
    }

    //Записывает структуру папок в файл
    public static void printTree(File file, String mask, FileWriter writer) {
        try {
            writer.append(file.getName() + "\n");
            if (file.isDirectory()) {
                int i = 0;
                for (File item : file.listFiles(file1 -> !file1.isHidden())) {
                    writer.append(String.format("%s%s\u2500\u2500\u2500", mask, i == file.listFiles().length - 1 ? "\u2514" : "\u251c"));
                    printTree(item, String.format("%s%s", mask, i == file.listFiles().length - 1 ? "    " : "\u2502   "), writer);
                    i++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Считывает файл и возвращает массив по строкам
    public static ArrayList<String> readFile(File file) {
        ArrayList<String> textByLine = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    i = 1;
                    continue;
                }
                line = line.substring(4).replaceAll("[\u2500,\u2514,\u2502,\u251c]", " ");
                textByLine.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return textByLine;
    }

    //Количество папок файл счтается папкой, если у него есть подфайлы или нет расширения
    public static int countDirs(List<String> files) {
        int count = 0;
        for (int i = 0; i < files.size() - 1; i++) {
            if (getSpacesBeforeName(files.get(i + 1)) > getSpacesBeforeName(files.get(i)) || files.get(i).indexOf('.') == -1) {
                count++;
            }
        }
        return count;
    }

    //Возвращает количество пробелов до начала текста строки
    public static int getSpacesBeforeName(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //Получаем среднее число файлов в папках. Исключаем файлы, лежащие в корне и получаем только файлы, разложенные по папкам
    public static double getAverageFileInDirsCount(List<String> files) {
        int countFilesInRoot = 0;
        for (int i = 0; i < files.size() - 1; i++) {
            if (files.get(i).trim().indexOf('.') != -1 && getSpacesBeforeName(files.get(i)) == 0) {
                countFilesInRoot++;
            }
        }
        int countDirs = countDirs(files);
        return (countDirs > 0) ? (double) (files.size() - countDirs - countFilesInRoot) / countDirs : 0;
    }

    //Получаем среднюю длину названия файлов
    public static double getAverageFileNameLength(List<String> files) {
        int countFiles = 0;
        int sumNamesLength = 0;
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).indexOf('.') != -1) {
                sumNamesLength += (files.get(i).trim()).substring(0, (files.get(i).trim()).lastIndexOf('.')).length();
                countFiles++;
            }
        }
        return (countFiles) > 0 ? (double) sumNamesLength / countFiles : 0;
    }
}
