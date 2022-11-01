package ca.bytetube._02_sort.cmp;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 8, 8, 12, 14};
        int i = indexOf(arr, 8);
        System.out.println(i);

        //System.out.println(search(arr, 1));
    }

    //use binary search to find the index of an element in a sorted array
    public static int indexOf(int[] array, int v) {
        //java---> mov esp ebp ---> (0,1)
        if (array == null || array.length == 0) return -1;
        //00001110010101010101111001
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) {
                end = mid;
            } else if (v > array[mid]) {
                begin = mid + 1;
            } else {
                return mid;
            }


        }

        return -1;


    }


    /**
     * 查询v在有序数组中的合适的插入位置
     * search for an appropriate insertion position  for element v
     */
    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;

    }
}
