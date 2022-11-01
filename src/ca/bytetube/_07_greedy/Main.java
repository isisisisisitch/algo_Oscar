package ca.bytetube._07_greedy;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] randArray = getRandArray(10, 1000);

        showArray(randArray);

        Arrays.sort(randArray,new MyComparator());
        showArray(randArray);
    }


    public static Integer[] getRandArray(int size, int bound){
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
           arr[i] = random.nextInt(bound);
        }


        return arr;

    }


    public static void showArray(Integer[] arr){
        for (int element :arr) {
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println("=======================================");

    }
}
