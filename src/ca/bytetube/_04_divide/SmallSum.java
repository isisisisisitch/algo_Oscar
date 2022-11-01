package ca.bytetube._04_divide;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
        //System.out.println(smallSum2(arr));

    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("arr is null or arr is empty!");

        return sort(arr, 0, arr.length - 1);
    }

    public static int sort(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = (left + right) >> 1;
        return sort(arr, left, mid) + sort(arr, mid + 1, right) + merge(arr, left, mid, right);

    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                sum += arr[p1] * (right - p2 + 1);
            }

            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) help[i++] = arr[p1++];
        while (p2 <= right) help[i++] = arr[p2++];

        for (int j = 0; j < help.length; j++) arr[left + j] = help[j];

        return sum;

    }


    public static int smallSum2(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }

        return sum;
    }


}
