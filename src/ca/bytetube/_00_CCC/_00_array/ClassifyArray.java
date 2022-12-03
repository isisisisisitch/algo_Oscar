package ca.bytetube._00_CCC._00_array;

public class ClassifyArray {
    public static void main(String[] args) {
        int[] arr = {10, 4, -4, 8, 7, 22, 109, 45, 67, 32, 5, 6, 4, 8, 66};
        classify(arr, 22);
        printArray(arr);

    }


    public static void classify(int[] arr, int pivot) {
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more) {
            if (arr[cur] < pivot) {
                int temp = arr[cur];
                arr[cur] = arr[less + 1];
                arr[less + 1] = temp;
                less++;
                cur++;
            } else if (arr[cur] > pivot) {
                more--;
                int temp = arr[cur];
                arr[cur] = arr[more];
                arr[more] = temp;

            } else {
                cur++;
            }
        }

    }

    public static void pivotArray(int[] arr, int pivot) {//10
        int length = arr.length;
        int[] arr1 = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = pivot;
        }

        int left = 0;
        int right = arr.length - 1;

        for (int i = 0; i < length; i++) {
            if (arr[i] < pivot) {
                arr1[left] = arr[i];
                left++;
            } else if (arr[i] > pivot) {
                arr1[right] = arr[i];
                right--;
            }
        }

        for (int i = 0; i < length; i++) {
            arr[i] = arr1[i];
        }
//        return arr1;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
