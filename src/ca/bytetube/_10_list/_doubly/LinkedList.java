package ca.bytetube._10_list._doubly;

import ca.bytetube._10_list.AbstractList;

public class LinkedList extends AbstractList {
    Node first;
    Node last;


    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;

    }


    private Node node(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("error index");
        if (index < (size >> 1)) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        } else {

            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

            return node;

        }

    }

    @Override
    public void add(int index, Object element) {

        if (index == size) {//tail
            Node oldLast = last;//null
            Node newLast = new Node(element, oldLast, null);
            last = newLast;
            //empty list
            if (size == 0) first = newLast;
            else oldLast.next = newLast;

        } else {//common / head
            Node next = node(index);//index = 0
            Node prev = next.prev;//null

            Node newNode = new Node(element, prev, next);
            next.prev = newNode;
            if (index == 0) first = newNode;

            else prev.next = newNode;

        }

        size++;
    }

    @Override
    public Object set(int index, Object element) {
        Node cur = node(index);
        Object temp = cur.element;
        cur.element = element;
        return temp;
    }

    @Override
    public Object remove(int index) {
        if (size == 0) return null;
        Node cur = node(index);

        if (size == 1) {
            last = null;
            first = null;
        } else if (index == size - 1) {
            cur.prev.next = null;
            last = cur.prev;
        } else if (index == 0) {
            first = cur.next;
            cur.next.prev = null;
        } else {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }

        size--;

        return cur.element;
    }

    @Override
    public int indexOf(Object element) {
        Node cur = first;
        int index= 0;
        while (cur.next!=null){
            if (cur.element.equals(element)) return index;
            index++;
            cur =cur.next;
        }
        return -1;
    }

    private static class Node {
        Object element;
        Node prev;
        Node next;

        public Node(Object element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 4; i++) {
            linkedList.add(10 + i);
        }

       // System.out.println(linkedList.remove(2));
//        System.out.println(linkedList.remove(0));

        while (!linkedList.isEmpty()){
            System.out.println(linkedList.remove(0));
        }

        //System.out.println();




    }

}
