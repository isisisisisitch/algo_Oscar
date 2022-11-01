package ca.bytetube._02_sort.uncmp;

import java.util.Random;

public class CountingSort {

    public static void main(String[] args) {
        int[] randArray = getRandArray(10, 1000);
        System.out.print("before sort:");
        printArray(randArray);
        sort(randArray);
        System.out.print("after sort:");
        printArray(randArray);
    }

    public static void sort(int[] array) {
        //1.find the max ,min values in array
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        //2.create an array to store the frequency of each element in array
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        //sum frequency of each element in array
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        //3.create a new array to store sorted data
        int[] newArray = new int[array.length];

        //4....
        for (int i = array.length - 1; i >= 0; i--) {
           // int index = counts[array[i] - min]--;
            newArray[--counts[array[i] - min]] = array[i];
        }

        //5.
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }


    }

    public static void sort0(int[] array) {
        //1.find the max value in array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        //2.create an array to store the frequency of each element in array
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        //3.sort array according to the frequency
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {//counts[i] = 2
                counts[i]--;//counts[i] = 0
                array[index] = i;
                index++;
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
