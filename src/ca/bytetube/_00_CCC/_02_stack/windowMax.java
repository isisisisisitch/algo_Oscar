package ca.bytetube._00_CCC._02_stack;

import java.util.Deque;
import java.util.LinkedList;


public class windowMax {

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 3, -3, -1, 8, 2};
        int[] samples = windowMax(arr, 3);
        printArray(samples);
    }

    public static int[] windowMax(int[] nums, int k) {
        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //1.if nums[i] >= nums[tail], remove tail element until nums[tail] > nums[i]
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.removeLast();

            //2.add index i into tail of dequeue
            deque.addLast(i);

            //2.5 remove expired head of dequeue if the index of dequeue head < W
            int w = i - k + 1;
            if (w < 0) continue;
            if (w > deque.peekFirst()) deque.removeFirst();

            //3.update window lax value at W position to nums[head]
            maxes[w] = nums[deque.peekFirst()];

        }

        return maxes;
    }


    public static int[] windowMax1(int[] nums, int k) {
        int[] dp = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (Math.max(dp[0], nums[i]) == nums[i]) {
                maxIndex = i;
            }
            dp[0] = Math.max(dp[0], nums[i]);

        }
        for (int i = k; i < nums.length; i++) {
            int lowerBound = i - k + 1;
            int upperBound = i;
            if (maxIndex < lowerBound) {
                dp[lowerBound] = nums[lowerBound];
                for (int j = lowerBound; j <= upperBound; j++) {
                    if (nums[j] > dp[lowerBound]) {
                        maxIndex = j;
                        dp[lowerBound] = nums[j];
                    }

                }
            } else {
                if (nums[upperBound] >= nums[maxIndex]) {
                    maxIndex = upperBound;
                    dp[lowerBound] = nums[maxIndex];
                } else {
                    dp[lowerBound] = dp[lowerBound - 1];
                }

            }
        }
        return dp;

    }


    public static void printArray(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }


}
