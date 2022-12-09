package ca.bytetube._10_list;

public class LinkedList  extends AbstractList{
    Node first;
    Node last;

    public LinkedList() { }


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


    private Node node(int index){
        if (index < 0 || index >= size)  throw new IndexOutOfBoundsException("error index");
        if (index < (size >> 1)) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        }else {

            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

            return node;

        }

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

    private static class Node{
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

}
