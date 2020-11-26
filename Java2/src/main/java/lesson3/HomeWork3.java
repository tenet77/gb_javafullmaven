package lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HomeWork3 {

    public static ArrayList<String> readWords() throws IOException {

        ArrayList<String> result = new ArrayList<String>();

        String path = HomeWork3.class.getClassLoader().getResource("words.txt").getPath();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            result.add(bufferedReader.readLine());
        }

        return result;

    }

    public static void main(String[] args) throws IOException {

        ArrayList<String> words = readWords();
        HashMap<String, Integer> uniqueSet = new HashMap<String, Integer>();
        for (String s : words) {
            if (uniqueSet.containsKey(s)) {
                Integer i = uniqueSet.get(s);
                uniqueSet.put(s, ++i);
            } else {
                uniqueSet.put(s, 1);
            }

        }

        for (Map.Entry<String, Integer> v : uniqueSet.entrySet()) {
            System.out.printf("Word: %s, contain - %d", v.getKey(), v.getValue());
            System.out.println();
        }

        PhoneCatalog phoneCatalog = new PhoneCatalog();
        phoneCatalog.add("Ivan", "+7 999 999 99 99");
        phoneCatalog.add("Ivan", "+7 888 888 88 88");
        phoneCatalog.add("Piotr", "+56 888 888 88 88");
        phoneCatalog.add("Vanya", "+7 555 888 88 88");

        printPhone(phoneCatalog, "Ivan");
        printPhone(phoneCatalog, "Vanya");
        printPhone(phoneCatalog, "John");

    }

    private static void printPhone(PhoneCatalog phoneCatalog, String name) {
        ArrayList<String> phone = phoneCatalog.get(name);
        System.out.println("Name: " + name);
        System.out.println("Phones:");
        for (String s : phone) {
            System.out.println(s);
        }
    }

}
