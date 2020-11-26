package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneCatalog {

    private final HashMap<String, ArrayList<String>> phones;

    public PhoneCatalog() {
        phones = new HashMap<String, ArrayList<String>>();
    }

    public void add(String name, String phone) {
        ArrayList<String> p = new ArrayList<String>();
        if (phones.containsKey(name)) {
            p = phones.get(name);
        }
        p.add(phone);
        phones.put(name, p);
    }

    public ArrayList<String> get(String name) {
        ArrayList<String> result = new ArrayList<String>();
        if (phones.containsKey(name)) {
            result = phones.get(name);
        }
        return result;
    }
}

