package ca.bytetube._04_divide;

import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.util.Arrays.copyOfRange;

public class GetMaxFromArray {


    public static void main(String[] args) {
        int[] randArray = getRandArray(10, 1000);
        printArray(randArray);
        int max = getMaxFromArray2(randArray);
        System.out.println("max in arr is " + max);

    }

    public static int maxInArray(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("array is null or empty");
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return arr[0] > arr[1] ? arr[0] : arr[1];

        int left = maxInArray(Arrays.copyOfRange(arr, 0, StrictMath.round(arr.length / 2)));
        int right = maxInArray(Arrays.copyOfRange(arr, StrictMath.round(arr.length / 2), arr.length));
        return left > right ? left : right;
    }



    public static int getMaxFromArray2(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null or arr is empty!");
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return arr[0] > arr[1] ? arr[0] : arr[1];


        return getMaxFromArray2(arr, 0, arr.length - 1);
    }

    public static int getMaxFromArray2(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        int mid = (left + right) >> 1;
        int leftMax = getMaxFromArray2(arr, left, mid);
        int rightMax = getMaxFromArray2(arr, mid + 1, right);
        return leftMax > rightMax ? leftMax : rightMax;

    }


    public static int getMaxFromArray1(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null or arr is empty!");
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return arr[0] > arr[1] ? arr[0] : arr[1];

        Arrays.sort(arr);//O(n*logn)
        return arr[arr.length - 1];


    }

    public static int getMaxFromArray0(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null or arr is empty!");
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return arr[0] > arr[1] ? arr[0] : arr[1];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) if (max < arr[i]) max = arr[i];

        return max;
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
