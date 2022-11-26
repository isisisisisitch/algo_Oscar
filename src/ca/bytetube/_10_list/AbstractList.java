package ca.bytetube._10_list;

public abstract class AbstractList implements List{
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Object element) {
        add(size,element);
    }


    public abstract Object get(int index);


    public abstract void clear() ;


    public abstract void add(int index, Object element);


    public abstract Object set(int index, Object element) ;


    public abstract Object remove(int index);


    public abstract int indexOf(Object element);


    public abstract boolean contains(Object element);
}
