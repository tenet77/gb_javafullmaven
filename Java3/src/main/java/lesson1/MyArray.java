package lesson1;

import java.util.ArrayList;
import java.util.List;

public class MyArray<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public MyArray() {
        this.capacity = 128;
        this.size = 0;
        this.data = new Object[capacity];
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public void set(int index, T value) {
        if (index >= size) throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    public void add(T value) {
        validateCapacity();
        data[size] = value;
        size++;
    }

    private void validateCapacity() {
        if (size == capacity - 1) {
            capacity *=2;
            Object[] tmp = new Object[capacity];
            if (size > 0) {
                System.arraycopy(data, 0, tmp, 0, size);
            }
        }
    }

    public void remove() {
        size--;
    }

    public void swapElements(int indexFrom, int indexTo) {
        T tmp = get(indexFrom);
        set(indexFrom, get(indexTo));
        set(indexTo, tmp);
    }

    public ArrayList<T> toArrayList() {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(get(i));
        }

        return (ArrayList<T>) result;
    }

    @Override
    public String toString() {
        String result;
        result = "[";
        for (int i = 0; i < size; i++) {
            result += get(i);
            if (i<size-1) {
                result += ", ";
            }
        }
        result += "]";

        return result;
    }
}
