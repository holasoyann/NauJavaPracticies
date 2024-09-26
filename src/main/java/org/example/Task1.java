package org.example;

import java.util.Random;

/**
 * Вариант 1
 * Заполните массив (тип элементов “int”) случайными числами и
 * выполните задание в соответствии со своим вариантом.
 * 1. Найти максимальное значение по модулю в массиве.
 * Входные данные: количество элементов в формируемом массиве n [0, ∞).
 * Выходные данные: в консоль напечатаны массив и результат поиска в
 * соответствии с заданием.
 */


public class Task1 {
    private static int[] GetRandomNumbersArray(int size) {
        Random random = new Random();

        int[] randomNumbers = new int[Math.max(size, 0)];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(-100000, 100000);
        }
        return randomNumbers;
    }

    private static int FindMaxAbs(int size, int[] randomNumbers) {
        if (size <= 0) {
            return -1;
        }
        int max = Math.abs(randomNumbers[0]);

        for (int i = 1; i < randomNumbers.length; i++) {
            max = Math.max(max, Math.abs(randomNumbers[i]));
        }
        return max;
    }

    public static void execute(int n) {
        var randomNumbers = GetRandomNumbersArray(n);
        var max = FindMaxAbs(n, randomNumbers);

        System.out.print("Array content: ");
        for (int randomNumber : randomNumbers) {
            System.out.print(randomNumber + " ");
        }

        System.out.print("\nMax abs is: ");
        if (max >= 0)
            System.out.println(max);
        else
            System.out.println("None // Array has 0 elements or n<0");
    }
}
