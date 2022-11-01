package ca.bytetube._02_sort.cmp;

import java.util.Random;

public class InsertionSort3 {
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
            int insertIndex = search(arr, begin);
            int v = arr[begin];
            for (int i = begin; i > insertIndex ; i--) {
                arr[i] = arr[i-1];
            }
            arr[insertIndex] = v;
        }
    }
    /**
     * 查询v在有序数组中的合适的插入位置
     * search for an appropriate insertion position  for element v
     */
    public static int search(int[] array, int index) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (array[index] < array[mid])  end = mid;
            else  begin = mid + 1;
        }
        return begin;
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