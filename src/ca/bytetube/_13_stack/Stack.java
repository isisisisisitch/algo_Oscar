package ca.bytetube._13_stack;

import ca.bytetube._13_stack.list.SinglyLinkedList;

public class Stack {

    private SinglyLinkedList linkedList = new SinglyLinkedList();

    // Number of elements
    public int size() {

        return linkedList.size();
    }


    // Is stack empty
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    // Push
    public void push(Object element) {
        linkedList.add(element);
    }


    public Object pop() {
        return linkedList.remove(linkedList.size() - 1);
    }


    // Get the top element of the stack
    public Object top() {
        return linkedList.get(linkedList.size() - 1);
    }


    // Clear all elements in stack
    public void clear() {
        linkedList.clear();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i+ 10);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }


}
