package ca.bytetube._02_sort.cmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShellSort {
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
        List<Integer> stepSequence = shellSequence(arr);
        for (Integer step : stepSequence) {
            shell(arr, step);
        }
    }
    /**
     * sort sequence is divided into step cols
     */
    private static void shell(int[] arr, int step) {

        for (int col = 0; col < step; col++) {
            //insertion
            insertionSort(arr,col,step);
        }

    }

    private static void insertionSort(int[] arr,int col,int step){
        for (int begin = col + step; begin < arr.length; begin += step) {
            int cur = begin;
            //col,col + step,col + 2step...
            while (cur > col && arr[cur] < arr[cur - step]) {//put element in to be sorted into an appropriate position in the beginning
                int temp = arr[cur];
                arr[cur] = arr[cur - step];
                arr[cur - step] = temp;
                cur -= step;

            }

        }
    }

    /**
     * get a step sequence of an array
     *
     * @return step sequence
     */
    private static List<Integer> shellSequence(int[] array) {
        List<Integer> list = new ArrayList<>();
        //...
        int step = array.length;//16
        while ((step >>= 1) > 0) {
            list.add(step);
        }

        return list;
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
