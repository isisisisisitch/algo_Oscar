package ca.bytetube._02_sort.uncmp;


import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        double[] array = {0.34,0.47,0.29,0.84,0.45,0.38,0.35,0.76};
        printArray(array);
        sort(array);
        printArray(array);

    }

    /**
     * process:
     * 1.create some buckets(such as array,list)
     * 2.put data in different buckets according to a rule
     * 3.sort each bucket
     * 4.merge non-empty buckets
     * @param array
     */
    public static void sort(double[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        //1.create some buckets(such as array,list)
        List<Double>[] buckets = new List[array.length];

        // 2.put data in different buckets according to a rule
        for (int i = 0; i < array.length; i++) {
          int bucketIndex = (int) (array[i] * array.length);
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }

      //3.sort each bucket
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            //list--->array
//            buckets[i].sort(null);
            double[] sortedArray = convertListToSortedArray(buckets[i]);
            //4.merge non-empty buckets
            for (Double d:sortedArray) {
                array[index] = d;
                index++;
            }
        }

    }

    private static double[] convertListToSortedArray(List<Double> list){
        double[] array = new double[list.size()];
        //1.convert list to array
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        //2.sort array
        sortSubArray(array);
        return array;
    }


    private static void sortSubArray(double[] arr){
        for (int begin = 1; begin < arr.length; begin++) {
            int insertIndex = search(arr, begin);
            double v = arr[begin];
            for (int i = begin; i > insertIndex ; i--) {
                arr[i] = arr[i-1];
            }
            arr[insertIndex] = v;
        }
    }

    private static int search(double[] array, int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (array[index] < array[mid])  end = mid;
            else  begin = mid + 1;
        }
        return begin;
    }



    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
