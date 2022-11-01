package ca.bytetube._02_sort.cmp;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] randArray = getRandArray(10, 1000);
        System.out.print("before sort:");
        printArray(randArray);
        sort(randArray);
        System.out.print("after sort:");
        printArray(randArray);
    }

    public static void sort(int[] arr) {
        sort(arr,0,arr.length);
    }

    private static void sort(int[] arr,int begin,int end){

        if (end - begin < 2) return;

        int pivot = pivotIndex(arr, begin, end);
        sort(arr,begin,pivot);
        sort(arr,pivot + 1,end);


    }

    private static int pivotIndex(int[] arr,int begin,int end){//[6,11)
        swap(arr,begin, begin + (int) (Math.random()*(end - begin)));//offset
        //Math.random()*(end - begin)[0,1)
        //1.backup pivot
        int pivot = arr[begin];
        end--;
        while (begin < end){
            //right ---> left
            while (begin < end){
                if (pivot < arr[end]) {
                    end--;
                }else {//pivot >= arr[end]
                    arr[begin] = arr[end];
                    begin++;
                    break;//change direction
                }
            }
            //left ---> right
            while (begin < end){

                if (pivot > arr[begin]) {
                    begin ++;
                }else {//pivot <= arr[begin]
                    arr[end] = arr[begin];
                    end--;
                    break;//change direction
                }
            }
        }
        //begin == end
        arr[begin] = pivot;


        return begin;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
