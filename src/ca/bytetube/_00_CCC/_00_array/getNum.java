package ca.bytetube._00_CCC._00_array;

import java.util.Deque;
import java.util.LinkedList;

public class getNum {
    public static void main(String[] args) {

    }


    public static int getNum(int[] arr, int num){
        int total = 0;
        //1. iterate every k value for windowMax and windowMin
        //2. in iteration, get difference of every max value and min value
        //3. in iteration, add to total if difference < num;


        return total;
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

    public static int[] windowMin(int[] nums, int k) {
        int[] mins = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //1.if nums[i] >= nums[tail], remove tail element until nums[tail] > nums[i]
            while (!deque.isEmpty() && nums[i] < nums[deque.peekLast()]) deque.removeLast();

            //2.add index i into tail of dequeue
            deque.addLast(i);

            //2.5 remove expired head of dequeue if the index of dequeue head < W
            int w = i - k + 1;
            if (w < 0) continue;
            if (w > deque.peekFirst()) deque.removeFirst();

            //3.update window lax value at W position to nums[head]
            mins[w] = nums[deque.peekFirst()];

        }

        return mins;
    }
}
