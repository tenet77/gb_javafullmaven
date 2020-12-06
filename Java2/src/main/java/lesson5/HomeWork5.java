package lesson5;

import java.util.Arrays;

public class HomeWork5 {

    static final int size = 10_000_000;
    static final int h = size / 3;

    public static class MyThread implements Runnable {

        private final float[] arr;
        private final int processNumber;

        public MyThread(float[] arr, int processNumber) {
            this.arr = arr;
            this.processNumber = processNumber;
        }

        private void calculate() {

            long a = System.currentTimeMillis();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            System.out.printf("Method 2, proc %d : %d ms", processNumber, (System.currentTimeMillis() - a));
            System.out.println();
        }

        @Override
        public void run() {
            calculate();
        }
    }

    public static void method1() {
        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Method 1 : " + (System.currentTimeMillis() - a) + " ms");
    }

    public static void method2() throws InterruptedException {

        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        long fullTime = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        float[] a3 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.arraycopy(arr, h * 2, a3, 0, h);

        System.out.println("Method 2 split array : " + (System.currentTimeMillis() - a) + " ms");

        Thread t1 = new Thread(new MyThread(a1, 1));
        Thread t2 = new Thread(new MyThread(a2, 2));
        Thread t3 = new Thread(new MyThread(a3, 3));

        t1.start();
        t2.start();
        t3.start();

        a = System.currentTimeMillis();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Method 2 process done : " + (System.currentTimeMillis() - a) + " ms");

        a = System.currentTimeMillis();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.arraycopy(a3, 0, arr, h * 2, h);

        System.out.println("Method 2 paste array : " + (System.currentTimeMillis() - a) + " ms");

        System.out.println("Method 2 : " + (System.currentTimeMillis() - fullTime) + " ms");

    }

    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();
    }
}
