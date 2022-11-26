package ca.bytetube._10_list;

public class LinkedList extends AbstractList {
    private Node first;

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(int index, Object element) {

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

    @Override
    public boolean contains(Object element) {
        return false;
    }


    private static class Node{
        Object element;
        Node next;


        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
