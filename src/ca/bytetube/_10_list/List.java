package ca.bytetube._10_list;

public interface List {

    public static final int ELEMENT_NOT_FOUND = -1;

    // Number of elements
    public int size();

    // Is it empty
    public boolean isEmpty();


    // Add elements to the end
    public void add(Object element);

    // Returns the element corresponding to the index position
    public Object get(int index);

    // Clear all the elements
    public void clear();

    // Add elements to the index position
    public void add(int index, Object element);


    // Set the element at the index position
    public Object set(int index, Object element);

    // Delete elements to the index position
    public Object remove(int index);

    // Return the index of the element
    public int indexOf(Object element);


    //Contains a certain element
    public boolean contains(Object element);
}
