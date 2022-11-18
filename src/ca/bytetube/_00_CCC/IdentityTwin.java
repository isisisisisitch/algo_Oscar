package ca.bytetube._00_CCC;

import java.util.*;

public class IdentityTwin {
    public static void main(String[] args) {


        identityTwin1(7,new int[] {1,5,3,2,2,2,2,3,1,4,1,4,1,5});
    }


    public static void identityTwin(int size , int[] arr){
        int[] arrCopy=arr;
        Arrays.sort(arrCopy);
        int newId = -1;

        for (int i = 1; i < arrCopy.length; i++) {

            if (arrCopy[i-1]!=arrCopy[i] && arrCopy[i]!=arrCopy[i+1]) {

                newId = arrCopy[i];
            } else if (arrCopy[i-1]==arrCopy[i]){
                arrCopy[i] = -1;
                arrCopy[i-1] = -1;
            }
        }

        System.out.println(newId);

    }

    public static void identityTwin1(int size , int[] arr){
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i],0);
        }

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i],hashMap.get(arr[i])+1);

        }
        boolean check = false;
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if ((value & 1) == 1) {
                System.out.println(key);
                check = true;
                break;
            }
        }
        if (check==false) System.out.println(-1);

    }
}
