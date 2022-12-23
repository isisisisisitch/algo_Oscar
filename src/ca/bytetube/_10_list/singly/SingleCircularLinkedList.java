package ca.bytetube._10_list.singly;

import ca.bytetube._10_list.AbstractList;

public class SingleCircularLinkedList extends AbstractList {
    private Node first;


    private Node node(int index){
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("error data");

        return node(index).val;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(int index, Object element) {////add(0,10)

        if (first == null){
            //empty
            first = new Node(element,null);
            first.next=first;
        }
        else if (index==0) {
            //start
            first = new Node(element, first.next);

            node(size - 1).next = first;
        } else {
            //normal and tail
            Node prev = node(index - 1);
            Node node = new Node(element, prev.next);
            prev.next = node;
        }



        size++;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    private static class Node {
        Object val;
        Node next;

        public Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "val=" + val +
//                    ", next=" + next +
//                    '}';
//        }
    }
}
