package ca.bytetube._10_list;

import java.util.Collection;
import java.util.Iterator;

public class ArrayList extends AbstractList {
    public Object[] elements;

    public static final int DEFAULT_CAPACITY = 10;


    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(Object[] elements) {
        if (elements == null) {
            this.elements = new Object[DEFAULT_CAPACITY];
        }else {
            this.elements = new Object[elements.length];
            for (int i = 0; i < elements.length ; i++) {
                this.elements[i] = elements[i];
            }
            size = elements.length;
        }

    }

    public ArrayList(Collection collection) {
        if (elements == null) {
            this.elements = new Object[DEFAULT_CAPACITY];
        }else {
            Iterator iterator = collection.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Object next = iterator.next();
                elements[index] = next;
                index++;
            }
            size = collection.size();
        }
    }





    // Returns the element corresponding to the index position
    public Object get(int index){
        return elements[index];
    };

    // Clear all the elements
    public void clear(){//memory leaking
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = null;
//        }
        size = 0;//gc
    };


    // Add elements to the index position
    public void add(int index, Object element){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("error index:" + index);
        extendCapacity(size + 1);
        for (int i = size ; i > index ; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    };


    // Set the element at the index position
    public Object set(int index,Object element){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("error index:" + index);
        Object oldEle = elements[index];
        elements[index] = element;
        return oldEle;
    };

    // Delete elements to the index position
    public Object remove(int index){
        Object oldEle = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i-1] = elements[i];
        }
         size--;
        return oldEle;
    };
    // Return the index of the element
    public int indexOf(Object element){
        if (element == null) {//10,20,30,null,70,30,null,90
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element) ) {//address
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;//hard code
    };


    //Contains a certain element
    public boolean contains(Object element){

        return indexOf(element) != ELEMENT_NOT_FOUND;
    };

    private void extendCapacity(int numsOfElements) {
        int oldCapacity = elements.length;
        if (oldCapacity >= numsOfElements) return;
        //1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object[] newElements = new Object[newCapacity];

        //move data from elements to newElements
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;


    }
}
