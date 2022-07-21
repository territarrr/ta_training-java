package com.epam.training.sofiia_uchitel.fundamentals.optional_task2;

import java.util.Arrays;
import java.util.Scanner;

enum Order {ASC, DESC};

/*

Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
 */
public class Main {
    public static void main(String[] args) {
        //Ввод размерности
        System.out.println("Введите размерность матрицы:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n < 1) {
            System.out.println("\nНеверный ввод. Размерность матрицы должна быть больше 1. Повторите ввод:");
            n = scanner.nextInt();
        }

        System.out.println("\nВведите целнчисло (M), в диапазоне которого [-M; M] будет заполняться матрица:");
        int m = scanner.nextInt();
        if (m < 0) {
            m *= -1;
        }
        //Создание матрицы
        Matrix matrix = new Matrix(n, m);
        System.out.println("Исходная матрица:");
        matrix.printMatrix();

        System.out.printf("\nВведите столбец от 1 до %d, по возрастанию элементов которого будут упорядочены строки\n", n);
        int k = scanner.nextInt();
        while (k > n || k < 1) {
            System.out.printf("\nНеверный ввод. Номер столбца не должен быть от 1 до %d\n", n);
            k = scanner.nextInt();
        }
        System.out.printf("\nМатрица, отсортированная по возрастанию элементов столбца %d:\n", k);
        matrix.sortByColumn(k);
        matrix.printMatrix();

        System.out.printf("\nВведите столбец от 1 до %d, по возрастанию элементов которого будут упорядочены строки\n", n);
        k = scanner.nextInt();
        while (k > n || k < 1) {
            System.out.printf("\nНеверный ввод. Номер столбца не должен быть от 1 до %d\n", n);
            k = scanner.nextInt();
        }
        System.out.printf("\nМатрица, отсортированная по возрастанию элементов строки %d:\n", k);
        matrix.sortByRow(k);
        matrix.printMatrix();

        System.out.println("\nНаибольшее число возрастающих элементов матрицы, идущих подряд по строкам (слева направо):");
        printSequenceWithLength(matrix.getElementSequenceOrdered(matrix.makeArrayByRow(), Order.ASC));

        System.out.println("\nНаибольшее число возрастающих элементов матрицы, идущих подряд по столбцам (сверху вниз):");
        printSequenceWithLength(matrix.getElementSequenceOrdered(matrix.makeArrayByColumn(), Order.ASC));

        System.out.println("\nНаибольшее число убывающих элементов матрицы, идущих подряд по строкам (слева направо):");
        printSequenceWithLength(matrix.getElementSequenceOrdered(matrix.makeArrayByRow(), Order.DESC));

        System.out.println("\nНаибольшее число убывающих элементов матрицы, идущих подряд по столбцам (сверху вниз):");
        printSequenceWithLength(matrix.getElementSequenceOrdered(matrix.makeArrayByColumn(), Order.DESC));

        System.out.printf("\nСумма элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки: %d\n", matrix.getMatrixSumBetweenFirstAndSecondPositiveElement());

//
//        System.out.println("\nКоординаты максимальных элементов:");
//        for (int t = 0; t < matrix.getMaxElementCoordinates().length; t++) {
//            System.out.println(Arrays.toString(matrix.getMaxElementCoordinates()[t]));
//        }

        System.out.println("\nМатрица без строк и столбцов, содержащих максимальные элементы:" );
        printArray(matrix.getMatrixWithoutRowsAndColumnsWithMaxElement());
    }

    public static void printSequenceWithLength(int[] sequence) {
        System.out.printf("Последовательность: %s. Количество элементов %d\n", Arrays.toString(sequence), sequence.length);
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
