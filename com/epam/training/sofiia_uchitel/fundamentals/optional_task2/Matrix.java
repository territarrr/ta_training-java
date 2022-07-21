package com.epam.training.sofiia_uchitel.fundamentals.optional_task2;

import java.util.Arrays;
import java.util.Random;


public class Matrix {
    private int n;
    private int m;
    private int[][] array;

    enum Position {ROW, COLUMN}

    public Matrix(int n, int m) {
        this.n = 5;
//        this.n = n;
        array = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = -m + rand.nextInt(2 * m + 1);
            }
        }

        array = new int[][]{{3, -97, -80, 13, -89}, {58, 39, -14, 91, 30}, {-32, 0, 91, 0, 47}, {-87, 0, 0, 14, 64}, {-10, 26, 22, 91, 0}};
    }

    public void printMatrix() {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    //Упорядочивание строк матрицы в порядке возрастания значений элементов k-го столбца
    public void sortByColumn(int k) {
        boolean isSorted = false;
        int[] tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < n; i++) {
                if (array[i][k - 1] < array[i - 1][k - 1]) {
                    isSorted = false;
                    tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
        }
    }

    //Упорядочивание столбцов матрицы в порядке возрастания значений элементов k-ой строки
    public void sortByRow(int k) {
        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < n - 1; j++) {
                if (array[k - 1][j] > array[k - 1][j + 1]) {
                    for (int i = 0; i < n; i++) {
                        isSorted = false;
                        tmp = array[i][j];
                        array[i][j] = array[i][j + 1];
                        array[i][j + 1] = tmp;
                    }
                }
            }
        }
    }


    //Разворачивает матрицу в массив по строкам
    public int[] makeArrayByRow() {
        int[] allElementsByRows = new int[n * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(array[i], 0, allElementsByRows, i * n, n);
        }
        return allElementsByRows;
    }

    //Разворачивает матрицу в массив по столбцам
    public int[] makeArrayByColumn() {
        int[] allElementsByColumn = new int[n * n];
        int k = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                allElementsByColumn[k++] = array[i][j];
            }
        }
        return allElementsByColumn;
    }


    //Поиск наибольшего числа возрастающих/убывающих элементов матрицы, идущих подряд
    //allElementsArray - массив, созданный из матрицы
    //order - порядок (во возрастанию/убыванию)
    public int[] getElementSequenceOrdered(int[] allElementsArray, Order order) {
        int maxStartIndex = 0;
        int currentStartIndex = 0;
        int currentLength = 1;
        int maxLength = 1;
        for (int i = 1; i < allElementsArray.length; i++) {
            if ((order == Order.ASC) ? allElementsArray[i - 1] < allElementsArray[i] : allElementsArray[i - 1] > allElementsArray[i]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStartIndex = currentStartIndex;
                }
            } else {
                currentStartIndex = i;
                currentLength = 1;
            }
        }
        int[] elementsSequenceOrdered = new int[maxLength];
        System.arraycopy(allElementsArray, maxStartIndex, elementsSequenceOrdered, 0, maxLength);
        return elementsSequenceOrdered;
    }

    //Поиск суммы элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
    public int getMatrixSumBetweenFirstAndSecondPositiveElement() {
        int sum = 0;
        for (int[] row : array) {
            sum += getArraySumBetweenFirstAndSecondPositiveElement(row);
        }
        return sum;
    }

    //Поиск сумму элементов между первым и вторым положительными элементи массивы
    public int getArraySumBetweenFirstAndSecondPositiveElement(int[] array) {
        int sum = 0;
        boolean start = false;
        int positiveNumberCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (positiveNumberCounter >= 2) {
                break;
            }
            if (array[i] < 0 && start) {
                sum += array[i];
            } else if (array[i] > 0 && !start) {
                start = true;
                positiveNumberCounter++;
            } else if (array[i] > 0 && start) {
                start = false;
                positiveNumberCounter++;
            }
        }
        return sum;
    }

    //Удаление в матрице всеx строк и столбцов, содержащих максимальных элемент
    public int[][] getMatrixWithoutRowsAndColumnsWithMaxElement() {
        //Подсчет количества строк и столбцов для новой матрицы, максимумов может быть несколько в одной строке/столбце
        int[] uniqueRows = getUniqueElementsInArrayByRowOrColumn(Position.ROW);
        int[] uniqueColumns = getUniqueElementsInArrayByRowOrColumn(Position.COLUMN);
        int[][] matrixWithoutRowsAndColumnsWithMaxElement = new int[array.length - uniqueRows.length][array[0].length - uniqueColumns.length];
        boolean containsRow;
        boolean containsColumn;
        int newMatrixRowIndex = 0;
        int newMatrixColumnIndex = 0;
        //Создание нового массива путем удалени строк и столбцов, содержащих максимумы
        for (int i = 0; i < array.length; i++) {
            containsRow = false;
            for (int k = 0; k < uniqueRows.length; k++) {
                if (uniqueRows[k] > i) {
                    break;
                }
                if (uniqueRows[k] == i) {
                    containsRow = true;
                    break;
                }
            }
            if (!containsRow) {
                for (int j = 0; j < array[0].length; j++) {
                    containsColumn = false;
                    for (int k = 0; k < uniqueColumns.length; k++) {
                        if (uniqueColumns[k] > j) {
                            break;
                        }
                        if (uniqueColumns[k] == j) {
                            containsColumn = true;
                            break;
                        }
                    }
                    if (!containsColumn) {
                        matrixWithoutRowsAndColumnsWithMaxElement[newMatrixRowIndex][newMatrixColumnIndex] = array[i][j];
                        newMatrixColumnIndex++;
                    }
                }
                newMatrixRowIndex++;
                newMatrixColumnIndex = 0;
            }
        }
        return matrixWithoutRowsAndColumnsWithMaxElement;
    }

    //Поиск уникальных значений в строках/столбцах массива координат максимальных значений матрицы
    private int[] getUniqueElementsInArrayByRowOrColumn(Position position) {
        int[][] maxElementsCoordinates = getMaxElementCoordinates();
        int[] uniqueElements = new int[0];
        int elementPosition;
        if (position == Position.ROW) {
            elementPosition = 0;
        } else {
            elementPosition = 1;
        }
        boolean containsCoordinate;
        for (int i = 0; i < maxElementsCoordinates.length; i++) {
            containsCoordinate = false;
            for (int j = 0; j < uniqueElements.length; j++) {
                if (uniqueElements[j] == maxElementsCoordinates[i][elementPosition]) {
                    containsCoordinate = true;
                    break;
                }
            }
            if (!containsCoordinate) {
                uniqueElements = Arrays.copyOfRange(uniqueElements, 0, uniqueElements.length + 1);
                uniqueElements[uniqueElements.length - 1] = maxElementsCoordinates[i][elementPosition];
            }
        }
        Arrays.sort(uniqueElements);
        return uniqueElements;
    }

    //Поиск координат максимальных элементов в матрице
    public int[][] getMaxElementCoordinates() {
        int[][] maxElementsCoordinates = new int[0][2];
        int max = getMaxElementValue();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == max) {
                    maxElementsCoordinates = Arrays.copyOfRange(maxElementsCoordinates, 0, maxElementsCoordinates.length + 1);
                    maxElementsCoordinates[maxElementsCoordinates.length - 1] = new int[]{i, j};
                }
            }
        }
        return maxElementsCoordinates;
    }

    //Поиск координат максимальных элементов в матрице
    public int getMaxElementValue() {
        int max = array[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
}
