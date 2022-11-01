package ca.bytetube._07_greedy;

import java.util.Arrays;

public class Pirates {
    public static void main(String[] args) {
        int count = loadAntiques(30, new int[]{3, 5, 4, 10, 7, 14, 2, 11});
        System.out.println(count);


    }


    public static int loadAntiques(int capacity,int[] weights){

        Arrays.sort(weights);
        int count = 0;
        int weight = 0;
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weights[i] + weight;
            if (newWeight <= capacity) {
                count++;
                weight = newWeight;
                System.out.println("Antiques: "+weights[i]);
            }
        }


        return count;
    }
}
