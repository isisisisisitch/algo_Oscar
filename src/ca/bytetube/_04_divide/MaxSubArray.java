package ca.bytetube._04_divide;

public class MaxSubArray {
    public static void main(String[] args) {
        int max = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(max);
    }


    public static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        return maxSubArray(arr, 0, arr.length);

    }

    //helper
    private static int maxSubArray(int[] arr, int begin, int end) {
        if (end - begin < 2) return arr[begin];
        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += arr[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += arr[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        //maxSubArray on the left of array
        return Math.max(leftMax + rightMax, Math.max(maxSubArray(arr, begin, mid), maxSubArray(arr, mid, end)));

    }


    public static int maxSubArray2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < arr.length; begin++) {
            int sum = 0;
            for (int end = begin; end < arr.length; end++) {
                sum += arr[end];
                max = Math.max(max, sum);

            }
        }
        return max;

    }

    public static int maxSubArray1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < arr.length; begin++) {

            for (int end = begin; end < arr.length; end++) {
                //sum [begin,end]
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += arr[i];
                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }


}
