package ca.bytetube._09_heap;

import ca.bytetube._09_heap.printer.BinaryTreeInfo;

//max heap
public class BinaryHeap implements BinaryTreeInfo {

    private Integer[] elements;
    private int size;//nums of elements
    public static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        elements = new Integer[DEFAULT_CAPACITY];
    }

    // the number of elements
    int size() {
        return size;
    }


    // is it empty
    boolean isEmpty() {
        return size == 0;
    }


    // clear elements
    void clear() {
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = null;
//        }
        size = 0;
    }


    // add elements
    void add(Integer element) {
        if (element == null) throw new NullPointerException("element can not be null !");
        extendCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);

    }

    private void extendCapacity(int numsOfElements) {
        int oldCapacity = elements.length;
        if (oldCapacity >= numsOfElements) return;
        //1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Integer[] newElements = new Integer[newCapacity];

        //move data from elements to newElements
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;


    }

    private void siftUp(int index) {
        Integer element = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            Integer parent = elements[parentIndex];
            //If node ≤ parent node
            if (element <= parent) break;

            //If node ＞ parent node
            elements[index] = parent;
            index = parentIndex;

        }
        elements[index] = element;


//        if (index!=0) {
//            int parentI = (index - 1) >> 1;
//            while (elements[index] > elements[parentI] && index != 0) {
//                parentI = (index - 1) >> 1;
//                int temp = elements[index];
//                elements[index] = elements[parentI];
//                elements[parentI] = temp;
//
//                index = parentI;
//
//
//
//            }
//        }
    }


    // get the top element of the heap
    Integer get() {
        emptyCheck();
        return elements[0];

    }

    private void emptyCheck() {
        if (size == 0) throw new RuntimeException("heap is empty!");
    }


    // delete the top element of the heap
    Integer remove() {

        int lastIndex = --size;
        Integer root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);


        return root;
    }

    private void siftDown(int index) {
        Integer element = elements[index];
        int half = size>>1;

        while (index < half) {
            //2 conditions
            //1.element--->left
            //2.element--->left and right
            int childIndex = (index << 1)+ 1;
            Integer child = elements[childIndex];
            int rightIndex = childIndex + 1;

            //get max from left,right
            if (rightIndex < size && (elements[rightIndex] > child)) {
                child = elements[childIndex = rightIndex];
            }

            if (element >= child) break;
            elements[index] = child;
            index = childIndex;

//            int leftChildIndex = 2 * index + 1;
//            Integer leftChild = elements[leftChildIndex];
//            int rightChildIndex =leftChildIndex + 1;
//            Integer rightChild = elements[rightChildIndex];
//
//            //If node ≤ parent node
//            if (rightChildIndex < size) {
//                int largest = leftChild;
//                int largestIndex = leftChildIndex;
//                if (rightChild > largest) {
//                    largest = rightChild;
//                    largestIndex = rightChildIndex;
//                }
//                if (element >= largest) break;
//
//                elements[index] = largest;
//                index = largestIndex;
//
//            } else if (rightChildIndex == size) {
//                if (element < leftChild) {
//                    elements[index] = leftChild;
//                    index = leftChildIndex;
//                } else break;
//            } else break
        }
        elements[index] = element;
    }


// insert a new element while deleting the top element of the heap

    Integer replace(Integer element) {
        Integer root = elements[0];
        elements[0] = element;
        siftDown(0);

        return root;
    }


    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;

        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;

        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}