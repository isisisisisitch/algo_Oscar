package ca.bytetube._10_list;

public class SinglyLinkedList extends AbstractList {
    private Node first;


    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    private Node node(int index){
        if (index < 0 || index >= size)  throw new IndexOutOfBoundsException("error index");
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size)  throw new IndexOutOfBoundsException("error index");
        if (index == 0)   first = new Node(element,first);
        else {
            Node prevNode = node(index - 1);
            Node nextNode = prevNode.next;

            /**
             * '=' assign value --->from right to left
             * '=' point to --->from left to right
             */
            prevNode.next = new Node(element, nextNode);//44
        }
        size++;

    }

    @Override
    public Object get(int index) {
        return node(index).element;
    }

    @Override
    public Object set(int index, Object element) {
        Node oldNode = node(index);
        Object oldElement = oldNode.element;
        oldNode.element = element;

        return oldElement;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size)  throw new IndexOutOfBoundsException("error index");
        Node removeNode = first;
        if (index == 0)  first = first.next;//null
        else {
            Node preNode = node(index - 1);
            removeNode = preNode.next;
            preNode.next = removeNode.next;
        }
        size--;
        return removeNode.element;
    }

    @Override
    public int indexOf(Object element) {

        if (element == null) {//10,20,30,null,70,30,null,90
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == element) return i;
                node = node.next;
            }
        }
        else {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    private static class Node {
        Object element;
        Node next;


        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
