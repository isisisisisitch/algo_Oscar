package ca.bytetube._02_sort.cmp;


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10,3,-5,77,91,34,31,4,3};
        sort(arr);
        printArray(arr);
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null or arr is empty!");

        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {

        if (left == right) return; ;
        int mid = (left + right) >> 1;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;
        while (p1 <= mid && p2 <= right) help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid) help[i++] = arr[p1++];
        while (p2 <= right) help[i++] = arr[p2++];

        for (int j = 0; j < help.length; j++)  arr[left + j] = help[j];



    }

    public static void printArray(int[] arr){
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }


}
