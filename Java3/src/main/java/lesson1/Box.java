package lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> content;

    public Box() {
        this.content = new ArrayList<>();
    }

    public void add(T value) {
        content.add(value);
    }

    public void remove(T value) {
        content.remove(value);
    }

    public float getWeight() {
        float result = 0;
        for (T f:content) {
            result += f.getWeight();
        }
        return result;
    }

    public boolean compare(Box<? extends IFruit> box) {
        return (this.getWeight() == box.getWeight());
    }

    public Box<T> pullOver() {
        Box<T> newBox = new Box<>();
        for (IFruit f:content) {
            newBox.add((T) f);
        }

        return newBox;
    }

    @Override
    public String toString() {
        String result = "";
        for (IFruit f:content) {
            result += f.toString() + ", ";
        }
        return result;
    }
}
