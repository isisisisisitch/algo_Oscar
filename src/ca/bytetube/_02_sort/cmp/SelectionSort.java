package ca.bytetube._02_sort.cmp;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] randArray = getRandArray(10, 1000);
        System.out.print("before sort:");
        printArray(randArray);
        sort(randArray);
        System.out.print("after sort:");
        printArray(randArray);
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIdx = 0;
            for (int begin = 0; begin <= end ; begin++) {
                if (arr[maxIdx] < arr[begin]) {
                    maxIdx = begin;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[end];
            arr[end] = temp;
        }

    }


    private static int[] getRandArray(int size, int bound) {
        int[] arr = new int[size];
        Random random = new Random();


        for (int i = 0; i < size; i++) {

            arr[i] = random.nextInt(bound);
        }


        return arr;

    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
