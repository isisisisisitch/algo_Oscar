package ca.bytetube._00_CCC;

public class MergeSortedArr {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,0,0,0};
        int[] arr2 = {2,4,6};
        int[] mergeSortedArr = mergeSortedArr(arr1, 3, arr2, 3);
        System.out.println(mergeSortedArr);
    }


    public static int[] mergeSortedArr(int[] arr1, int m, int[] arr2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = arr1.length - 1;

        while (i2 >= 0) {
            if (i1 >= 0 && arr1[i1] > arr2[i2]) {
                arr1[cur--] = arr1[i1--];
            } else arr1[cur--] = arr2[i2--];


        }
        return arr1;
    }
}
