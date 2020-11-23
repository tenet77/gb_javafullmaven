package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork2 {

    public static class MyArraySizeException extends Exception {

        @Override
        public String getMessage() {
            return "Check array size";
        }
    }

    public static class MyArrayDataException extends Exception {

        @Override
        public String getMessage() {
            return "Check data in array";
        }

    }

    public static int sumArray(String[][] ar) throws MyArraySizeException, MyArrayDataException {

        if (ar.length != 4) throw new MyArraySizeException();
        int result = 0;
        for (String[] strings : ar) {
            if (strings.length != 4) throw new MyArraySizeException();
            for (String string : strings) {
                try {
                    result += Integer.parseInt(string);
                } catch (Exception e) {
                    throw new MyArrayDataException();
                }
            }
        }

        return result;

    }

    public static void checkArray(String[][] ar) {

        try {
            int sum = sumArray(ar);
            System.out.printf("Array result = %d", sum);
            System.out.println();
        } catch (Exception e) {
            System.out.printf("Array result = %s", e.getMessage());
            System.out.println();
        }

    }

    public static void fillArray(String[][] ar, String st) {

        Scanner scan = new Scanner(st);
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scan.next();
            }
            System.out.println(Arrays.toString(ar[i]));
        }

    }

    public static void main(String[] args) {

        String[] testSt = new String[3];
        testSt[0] = "12 12 12 12 12 12 12 12 12 ss 12 12 12 12 12 12";
        testSt[1] = "12 11 10 6 7 5 12 12 12 3 12 12 12 12 12 12";
        testSt[2] = "12 12 12 12 12 12 12 12 12 12 12 12 12 12 12 12";

        String[][] ar = new String[4][4];

        for (String s : testSt) {

            fillArray(ar, s);
            checkArray(ar);

        }

        String testSt2 = "12 12 12 12 12 12 12 12 12 12 12 12 12 12 12 12 87 87 65 54";

        String[][] ar2 = new String[5][4];

        fillArray(ar2, testSt2);
        checkArray(ar2);

    }

}
