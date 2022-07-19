package com.epam.training.sofiia_uchitel.fundamentals.optional_task1;

import java.util.Arrays;

public class NumbersArray {
    private final int[] numbersArray;

    public NumbersArray(int[] numbersArray) {
        this.numbersArray = numbersArray;
    }

    //Поиск самого короткого числа (если длины равны, то берем минимальное число)
    public int getMinLengthNumber() {
        int min = this.numbersArray[0];
        for (int element :
                this.numbersArray) {
            if (String.valueOf(element).length() < String.valueOf(min).length()) {
                min = element;
            } else if (String.valueOf(element).length() == String.valueOf(min).length()) {
                min = Math.min(element, min);
            }
        }
        return min;
    }

    //Поиск самого длинного числа (если длины равны, то берем максимвльное число)
    public int getMaxLengthNumbers() {
        int max = this.numbersArray[0];
        for (int element :
                this.numbersArray) {
            if (String.valueOf(element).length() > String.valueOf(max).length()) {
                max = element;
            } else if (String.valueOf(element).length() == String.valueOf(max).length()) {
                max = Math.max(element, max);
            }
        }
        return max;
    }

    //Сортировка массива чисел в порядке возрастания значений их длин (если длины равны, то по возрастанию значений)
    public int[] sortByMaxLength() {
        int[] sortedArray = Arrays.copyOf(this.numbersArray, this.numbersArray.length);
        boolean sorted = false;
        int tmpElement;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (String.valueOf(sortedArray[i]).length() >= String.valueOf(sortedArray[i + 1]).length()) {
                    if (String.valueOf(sortedArray[i]).length() == String.valueOf(sortedArray[i + 1]).length()) {
                        if (sortedArray[i] > sortedArray[i + 1]) {
                            sorted = false;
                            tmpElement = sortedArray[i];
                            sortedArray[i] = sortedArray[i + 1];
                            sortedArray[i + 1] = tmpElement;
                        }
                    } else {
                        sorted = false;
                        tmpElement = sortedArray[i];
                        sortedArray[i] = sortedArray[i + 1];
                        sortedArray[i + 1] = tmpElement;
                    }
                }
            }
        }
        return sortedArray;
    }

    //Разворот массива
    public int[] reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = array.length; i > 0; i--) {
            reverseArray[reverseArray.length - i] = array[i - 1];
        }
        return reverseArray;
    }

    //Получение средней длины чисел переданного масива
    public double getAverageNumberLength() {
        int sumOfNumbersLength = 0;
        for (int element :
                this.numbersArray) {
            sumOfNumbersLength += String.valueOf(element).length();
        }
        return (double) sumOfNumbersLength / this.numbersArray.length;
    }

    //Получение числел, длина которых меньше средней длины по всем числам
    public int[] getNumbersLengthLessThanAverage() {
        int[] numbersLengthLessThanAverage = new int[0];
        double average = getAverageNumberLength();
        for (int element :
                this.numbersArray) {
            if (average > String.valueOf(element).length()) {
                numbersLengthLessThanAverage = Arrays.copyOf(numbersLengthLessThanAverage, numbersLengthLessThanAverage.length + 1);
                numbersLengthLessThanAverage[numbersLengthLessThanAverage.length - 1] = element;
            }
        }
        return numbersLengthLessThanAverage;
    }

    //Получение числел, длина которых больше средней длины по всем числам
    public int[] getNumbersLengthMoreThanAverage() {
        int[] numbersLengthMoreThanAverage = new int[0];
        double average = getAverageNumberLength();
        for (int element :
                this.numbersArray) {
            if (String.valueOf(element).length() > average) {
                numbersLengthMoreThanAverage = Arrays.copyOf(numbersLengthMoreThanAverage, numbersLengthMoreThanAverage.length + 1);
                numbersLengthMoreThanAverage[numbersLengthMoreThanAverage.length - 1] = element;
            }
        }
        return numbersLengthMoreThanAverage;
    }

    //Печать элементов массива и их длин
    public void printArrayElementsAndLength(int[] array) {
        for (int element :
                array) {
            System.out.printf("Элемент %d длиной %d;\n", element, String.valueOf(element).length());
        }
    }

    //Поиск числа, в котором количество различных цифр минимально. Если таких чисел несколько, поиск первого из них.
    public int getNumberWithMinimumUniqueDigits() {
        int minimumUniqueDigitsNumber = this.numbersArray[0];
        for (int element :
                this.numbersArray) {
            if (getUniqueDigitsCount(element) < getUniqueDigitsCount(minimumUniqueDigitsNumber)) {
                minimumUniqueDigitsNumber = element;
            }
        }
        return minimumUniqueDigitsNumber;
    }

    //Поиск количества уникальных цифр в числе
    public int getUniqueDigitsCount(int number) {
        int[] digits = new int[0];
        int digit;
        boolean containsDigit;
        if (number < 0) {
            number *= -1;
        }

        if (number == 0) {
            return 1;
        }

        while (number > 0) {
            containsDigit = false;
            digit = number % 10;
            for (int digitsElement :
                    digits) {
                if (digit == digitsElement) {
                    containsDigit = true;
                    break;
                }
            }
            if (!containsDigit) {
                digits = Arrays.copyOf(digits, digits.length + 1);
                digits[digits.length - 1] = digit;
            }
            number = number / 10;
        }

        return digits.length;
    }

    //Поиск чисел, содержащих только четные цифры
    public int[] getNumbersWithEvenDigits() {
        int[] numbersWithEvenDigits = new int[0];
        for (int element : this.numbersArray) {
            if (isOnlyEvenDigits(element)) {
                numbersWithEvenDigits = Arrays.copyOf(numbersWithEvenDigits, numbersWithEvenDigits.length + 1);
                numbersWithEvenDigits[numbersWithEvenDigits.length - 1] = element;
            }
        }
        return numbersWithEvenDigits;
    }

    //Проверка содержания только четных цифр в числе
    public boolean isOnlyEvenDigits(int number) {
        int digit;
        if (number < 0) {
            number *= -1;
        }
        while (number > 0) {
            digit = number % 10;
            if (digit % 2 != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    //Поиск чисел с равным числом четных и нечетных цифр.
    public int[] getNumbersWithEqualsCountEvenAndNotEvenDigits() {
        int[] numbersWithEqualsCountEvenAndNotEvenDigits = new int[0];
        for (int element : this.numbersArray) {
            if (isEqualsCountEvenAndNotEvenDigits(element)) {
                numbersWithEqualsCountEvenAndNotEvenDigits = Arrays.copyOf(numbersWithEqualsCountEvenAndNotEvenDigits, numbersWithEqualsCountEvenAndNotEvenDigits.length + 1);
                numbersWithEqualsCountEvenAndNotEvenDigits[numbersWithEqualsCountEvenAndNotEvenDigits.length - 1] = element;
            }
        }
        return numbersWithEqualsCountEvenAndNotEvenDigits;
    }

    //Проверка содержания одинакового количества четных и нечетных цифр в числе
    public boolean isEqualsCountEvenAndNotEvenDigits(int number) {
        int digit;
        int countEven = 0;
        int countNotEven = 0;
        if (number == 0) {
            return false;
        }
        if (number < 0) {
            number *= -1;
        }
        while (number > 0) {
            digit = number % 10;
            if (digit % 2 != 0) {
                countNotEven++;
            } else {
                countEven++;
            }
            number = number / 10;
        }
        return countEven == countNotEven;
    }

    //Поиск числа, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public String getNumberWithAscendingDigits() {
        for (int element : this.numbersArray) {
            if (isAscendingDigits(element)) {
                return String.valueOf(element);
            }
        }
        return "В массиве нет таких чисел";
    }

    //Проверка на возрастание цифр в числе
    public boolean isAscendingDigits(int number) {
        if (number < 0) {
            number *= -1;
        }
        int digit = number % 10;
        number = number / 10;
        while (number > 0) {
            if (digit <= number % 10) {
                return false;
            }
            digit = number % 10;
            number = number / 10;
        }
        return true;
    }

    //Поиск числа, состоящего только из различных цифр. Если таких чисел несколько, найти первое из них.
    public String getNumberWithOnlyUniqueDigits() {
        for (int element : this.numbersArray) {
            if (isNumberWithAllUniqueDigits(element)) {
                return String.valueOf(element);
            }
        }
        return "В массиве нет таких чисел";
    }

    //Проверка на уникальность всех цифр в числе
    public boolean isNumberWithAllUniqueDigits(int number) {
        if (String.valueOf(number).length() == getUniqueDigitsCount(number))
            return true;
        return false;
    }
}
