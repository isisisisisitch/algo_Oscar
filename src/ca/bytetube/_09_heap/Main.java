package ca.bytetube._09_heap;

import ca.bytetube._09_heap.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {

        BinaryHeap heap = new BinaryHeap();
        Integer[] arr = {72, 68, 50, 43, 38, 47, 21, 14, 80};
        topK(arr, 4);
//        for (int i = 0; i <arr.length ; i++) {
//            heap.add(arr[i]);
//        }
//
//        BinaryTrees.println(heap);
//
//        heap.remove();
//        BinaryTrees.println(heap);
//        heap.replace(11);
//        BinaryTrees.println(heap);
    }

    public static void topK(Integer[] data, int k) {
        BinaryHeap heap = new BinaryHeap();

        for (int i = 0; i < data.length; i++) {
            if (heap.size() < k) {
                heap.add(data[i]);
            } else if (data[i] < heap.get()) {
                heap.replace(data[i]);
            }
        }

        BinaryTrees.println(heap);
    }
}
