package ca.bytetube._14_queue;

import ca.bytetube._14_queue.list.SinglyLinkedList;

public class Queue {

    private SinglyLinkedList list;

    public Queue() {

        list = new SinglyLinkedList();
    }

    // Number of elements
    int size() {
        return list.size();
    }



    // Is it empty
    boolean isEmpty() {
        return list.isEmpty();
    }


    // Clear elements
    void clear() {
        list.clear();
    }


    //enQueue
    void enQueue(Object element) {
        list.add(element);
    }



    // deQueue
    Object deQueue() {
        return list.remove(0);
    }


    //Get the head element
    Object front() {
        return list.get(0);
    }




}
