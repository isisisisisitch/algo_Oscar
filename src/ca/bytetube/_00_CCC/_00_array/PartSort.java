package ca.bytetube._00_CCC._00_array;

import java.util.Arrays;
import java.util.Random;

public class PartSort {
    public static void main(String[] args) {
        int[] randArray = randArray(10, 100);
        print(randArray);
        int[] nums = sort(randArray);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }


    public static int[] sort(int[] nums) {
        int r = -1, l = -1;
        int max = nums[0];
        for (int cur = 1; cur < nums.length; cur++) {
            if (nums[cur] >= max) {
                max = nums[cur];
            } else {
                r = cur;
            }
        }
        int min = nums[nums.length - 1];

        for (int cur = nums.length - 2; cur >= 0; cur--) {
            if (nums[cur] <= min) {
                min = nums[cur];
            } else {
                l = cur;
            }
        }
        return new int[]{l, r};
    }

    public static int[] sort1(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(nums);//nlogn

        int[] range = new int[]{-1, -1};
        if (nums == temp) return range;
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != nums[i]) range[1] = i;

        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (temp[i] != nums[i]) range[0] = i;
        }
        return range;

    }


    public static int[] randArray(int count, int bound) {
        Random random = new Random();

        int[] arr = new int[count];
        arr[0] = 0;
        for (int k = 1; k < count - 1; k++) {
            int i = random.nextInt(bound);
            int j = random.nextInt(bound);
            arr[k] = i;
        }
        arr[count - 1] = 10000;

        return arr;


    }


    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
