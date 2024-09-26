package org.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * Вариант 1
 * Заполните список (тип “ArrayList<Double>”) случайным числами и
 * отсортируйте его.
 * 1. Сортировка слиянием (Merge Sort).
 * Входные данные: количество элементов в формируемом массиве n [0, ∞).
 * Выходные данные: в консоль напечатаны исходный и отсортированный
 * списки.
 */


public class Task2 {
    private static ArrayList<Double> GetRandomNumbersArray(int size) {
        Random random = new Random();

        ArrayList<Double> randomNumbers = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(random.nextDouble(-100000, 100000));
        }
        return randomNumbers;
    }

    private static void Merge(ArrayList<Double> array, ArrayList<Double> right, ArrayList<Double> left){
        int i=0, j=0, k=0;
        while(i<left.size() && j<right.size()){
            if (left.get(i) <= right.get(j)){
                array.set(k++, left.get(i++));
            }
            else {
                array.set(k++, right.get(j++));
            }
        }
        while(i<left.size()){
            array.set(k++, left.get(i++));
        }
        while(j<right.size()){
            array.set(k++, right.get(j++));
        }
    }

    private static void MergeSort(ArrayList<Double> randomNumbers) {
        int size = randomNumbers.size();
        if (size < 2)
            return;

        int mid = size / 2;
        ArrayList<Double> leftArray = new ArrayList<>(randomNumbers.subList(0, mid));
        ArrayList<Double> rightArray = new ArrayList<>(randomNumbers.subList(mid, size));

        MergeSort(leftArray);
        MergeSort(rightArray);

        Merge(randomNumbers, leftArray, rightArray);
    }

    public static void execute(int n) {
        var randomNumbers = GetRandomNumbersArray(n);

        System.out.println("ArrayList before sort: ");
        for (Double randomNumber : randomNumbers) {
            System.out.print(String.format("%.3f ",randomNumber));
        }

        MergeSort(randomNumbers);


        System.out.println("\nArrayList after sort: ");
        for (Double randomNumber : randomNumbers) {
            System.out.print(String.format("%.3f ",randomNumber));
        }

    }
}
