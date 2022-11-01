package ca.bytetube._02_sort.cmp;

import java.util.Random;

public class InsertionSort {
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
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            while (cur > 0 && arr[cur] < arr[cur - 1]){//put element in to be sorted into an appropriate position in the beginning
                int temp = arr[cur];
                arr[cur] = arr[cur - 1];
                arr[cur - 1] = temp;
                cur--;

            }

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