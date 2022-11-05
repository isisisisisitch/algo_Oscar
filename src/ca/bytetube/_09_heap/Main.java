package ca.bytetube._09_heap;

public class Main {
    public static void main(String[] args) {

        BinaryHeap heap = new BinaryHeap();
        int[] arr = {72, 68 ,50 ,43 ,38 ,47 ,21, 14 ,80};
        for (int i = 0; i <arr.length ; i++) {
            heap.add(arr[i]);
        }

        System.out.println("end");
    }
}
