package ca.bytetube._07_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeastMoney {
    public static void main(String[] args) {
        int[] arr = {20,10,30,40,50};
        System.out.println(leastMoney(arr));
       // System.out.println(leastMoney0(arr));
    }

    public static int leastMoney(int[] arr){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int ele : arr) {
            minHeap.add(ele);
        }
        int cost = 0;

        while (minHeap.size() > 1){
            int subCost = minHeap.poll() + minHeap.poll();
            cost += subCost;
            minHeap.add(subCost);
        }


        return cost;
    }


    // error!
//    public static int leastMoney0(int[] arr){//[20,10,30]
//        Arrays.sort(arr);//[10,20,30]
//        int cost = 0;
//        for (int i = arr.length - 1; i > 0; i--) {
//            //1.sub cost
//            int subCost = subCost(arr, i);
//            //2.calculate cost
//            cost += subCost;
//        }
//
//
//        return cost;
//
//    }
//
//    private static int subCost(int[] arr, int size){
//        int cost = 0;
//        for (int i = size; i >= 0 ; i--) {
//            cost += arr[i];
//        }
//
//        return cost;
//    }

}
