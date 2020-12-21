package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork1 {

    public static void main(String[] args) {
        MyArray<Integer> arr1 = new MyArray<>();
        arr1.add(0);
        arr1.add(1);
        System.out.println(arr1.toString());
        arr1.swapElements(0, 1);
        System.out.println(arr1.toString());

        MyArray<String> arr2 = new MyArray<>();
        arr2.add("aaaaaa");
        arr2.add("bbbbbb");
        System.out.println(arr2.toString());
        arr2.swapElements(0, 1);
        System.out.println(arr2.toString());

        System.out.println(arr1.toArrayList().toString());

        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println(box1.toString());

        Box<Orange> box2 = new Box<>();
        box2.add(new Orange());
        box2.add(new Orange());
        System.out.println(box2.toString());

        Box<Orange> newBox = box2.pullOver();
        System.out.println(newBox.toString());



    }

}
