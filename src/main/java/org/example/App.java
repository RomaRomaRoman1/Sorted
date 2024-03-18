package org.example;

import java.util.Arrays;
import java.util.Random;

public class App {
    // Метод для генерации случайного массива заданной длины
    private static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    // Метод для сортировки массива методом быстрой сортировки
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Вспомогательный метод для быстрой сортировки - разделение массива на подмассивы
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Метод для сортировки массива методом пузырьковой сортировки
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Метод для измерения времени выполнения сортировки массива
    private static long measureSortingTime(int[] arr, SortingMethod sortingMethod) {
        long startTime = System.nanoTime();
        sortingMethod.sort(arr);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // Преобразование наносекунд в миллисекунды
    }

    // Перечисление для определения метода сортировки
    private enum SortingMethod {
        QUICK_SORT,
        BUBBLE_SORT;

        // Метод для выбора метода сортировки
        public void sort(int[] arr) {
            switch (this) {
                case QUICK_SORT:
                    quickSort(arr, 0, arr.length - 1);
                    break;
                case BUBBLE_SORT:
                    bubbleSort(arr);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Генерация массива
        int[] arr = generateRandomArray(10_000);

        // Копирование массива для сравнения двух методов сортировки
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        // Измерение времени выполнения сортировки методом быстрой сортировки
        long quickSortTime = measureSortingTime(arr, SortingMethod.QUICK_SORT);

        // Измерение времени выполнения сортировки методом пузырьковой сортировки
        long bubbleSortTime = measureSortingTime(arrCopy, SortingMethod.BUBBLE_SORT);

        // Вывод результатов
        System.out.println("При сортировке массива длиной " + arr.length + " элементов:");
        System.out.println("Quick сортировка: " + quickSortTime + " ms");
        System.out.println("Bubble сортировка: " + bubbleSortTime + " ms");
    }
}