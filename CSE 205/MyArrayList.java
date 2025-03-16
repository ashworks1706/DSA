import java.util.ArrayList;

public class MyArrayList<T extends Comparable<T>> implements IList<T> {
    private ArrayList<T> list = new ArrayList<T>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }
    
    @Override
    public void set(int index, T item) {
        list.set(index, item);
    }

    @Override
    public void insert(int index, T item) {
        list.add(index, item);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }
}