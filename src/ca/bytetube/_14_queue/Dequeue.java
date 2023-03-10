package ca.bytetube._14_queue;

import ca.bytetube._10_list._doubly.LinkedList;

public class Dequeue {
    LinkedList dq;

    public Dequeue(){
        dq = new LinkedList();
    }
    int size(){
        return dq.size();
    }; // Number of elements



    boolean isEmpty(){
        return dq.isEmpty();
    }; // Is it empty


    void clear(){
        dq.clear();
    }; // Clear elements



    void enQueueRear(Object element){
        dq.add(0,element);
    }; // enQueue from the rear end


    Object deQueueFront(){
        return dq.remove(dq.size()-1);
    };// deQueue from the front end


    void enQueueFront(Object element){
        dq.add(dq.size()-1,element);
    }; // enQueue from the front end


    Object deQueueRear(){
        return dq.remove(0);
    }; // deQueue
}
