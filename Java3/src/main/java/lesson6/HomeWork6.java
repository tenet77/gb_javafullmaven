package lesson6;

import java.util.Arrays;

public class HomeWork6 {

    public static int[] getPart(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) index = i;
        }

        if (index == -1) {
            throw new RuntimeException("4 not exist");
        } else if (index == arr.length - 1) return new int[0];

        int[] res = new int[arr.length - index - 1];
        System.arraycopy(arr, index + 1, res, 0, res.length);

        return res;

    }

    public static boolean check14(int[] arr) {

        for (int i : arr) {
            if (i == 1 || i == 4) return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
