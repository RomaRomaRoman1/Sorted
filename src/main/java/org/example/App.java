package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;
public class App{
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);

                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

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

    public static void main(String[] args) {
            Random random = new Random(10000);
            int[] arrQuick = new int[1000000];
            for (int i=0; i<arrQuick.length; i++){
                arrQuick[i] = random.nextInt();
            }
            int n = arrQuick.length;
            int[] arrBobble = arrQuick;
            LocalTime startTime = LocalTime.now();
            quickSort(arrQuick, 0, n - 1);
            LocalTime endTime = LocalTime.now();
        LocalTime startTime2 = LocalTime.now();
        bubbleSort(arrBobble);
        LocalTime endTime2 = LocalTime.now();
            long durationQuick = Duration.between(startTime,endTime).toMillis();
            long durationBubble = Duration.between(startTime2,endTime2).toMillis();
            System.out.println("Quick = " + durationQuick + "\n" + "Bubble = " + durationBubble);
        //Быстрее явно Quick, лучше его использовать.
        }
}