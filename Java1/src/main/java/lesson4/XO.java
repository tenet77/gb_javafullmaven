package lesson4;

import java.util.Scanner;

public class XO {

    private static char[][] MAP;
    private static final char DEFAULT = '-';
    private static int SIZE;
    private static int COUNT;
    private static int turnLeft;

    public static final char USER = 'X';
    public static final char PC = '0';

    static class BlockPoint {
        public int maxLen, x, y;
        BlockPoint() {
            maxLen = -1;
            x = -1;
            y = -1;
        }
    }

    static void fillMap(int size, int count) {

        if (count > size) count = size;
        SIZE = size;
        COUNT = count;
        turnLeft = size * size;
        MAP = new char[size][size];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {

        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d", i + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%-2d", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2s", MAP[i][j]);
            }
            System.out.println();
        }
    }

    static boolean move(int x, int y, char player) {
        try {
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = player;
                turnLeft--;
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static char isVictory() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] != DEFAULT) {
                    if (checkCell(i, j, MAP[i][j])) {
                        return MAP[i][j];
                    }
                }
            }
        }
        return DEFAULT;
    }

    private static boolean checkCell(int x, int y, char player) {

        for (int signX = -1; signX <= 1; signX++) {
            for (int signY = -1; signY <= 1; signY++) {

                if (signX == 0 && signY == 0) continue;
                int cnt = 0;

                for (int i = 0; i < COUNT; i++) {
                    int newX = x + i * signX;
                    int newY = y + i * signY;

                    if (newX < 0 || newY < 0 || newX >= SIZE || newY >= SIZE) break;
                    if (MAP[newX][newY] == player) cnt++; else break;
                }

                if (cnt == COUNT) return true;
            }
        }
        return false;
    }

    private static void moveAI() {

        BlockPoint newPoint = new BlockPoint();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == USER) {
                    setBlockPoint(i, j, newPoint);
                }
            }
        }

        if (newPoint.maxLen != -1) {
            move(newPoint.x, newPoint.y, PC);
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) {
                    move(i, j, PC);
                    return;
                }
            }
        }
    }

    private static void setBlockPoint(int x, int y, BlockPoint point) {

        for (int signX = -1; signX <= 1; signX++) {
            for (int signY = -1; signY <= 1; signY++) {

                if (signX == 0 && signY == 0) continue;

                int cnt = 0;

                for (int i = 0; i < COUNT; i++) {
                    int newX = x + i * signX;
                    int newY = y + i * signY;

                    if (newX < 0 || newY < 0 || newX >= SIZE || newY >= SIZE) break;
                    if (MAP[newX][newY] == USER) cnt++;
                    if (MAP[newX][newY] == PC) break;
                    if (MAP[newX][newY] == DEFAULT) {
                        if (cnt > point.maxLen) {
                            point.maxLen = cnt;
                            point.x = newX;
                            point.y = newY;
                        }
                    }
                }
            }
        }
    }

    public static boolean isEndOfGame() {
        if (turnLeft == 0) {
            System.out.println("Ходов больше нет. Ничья");
            return true;
        }
        char player = isVictory();
        if (player == USER) {
            System.out.println("Вы выиграли");
            return true;
        } else if (player == PC) {
            System.out.println("Компьютер выиграл");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность и количество в ряд: ");
        int size = scanner.nextInt();
        int count = scanner.nextInt();
        fillMap(size, count);

        printMap();

        while (true) {

            System.out.print("Ваш ход: ");
            try {
                int x = scanner.nextInt();
                x--;

                int y = scanner.nextInt();
                y--;

                if (!move(x, y, USER)) {
                    System.out.println("Введите корректные данные.");
                    continue;
                }

                if (isEndOfGame()) break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Введите корректные данные.");
                continue;
            }

            moveAI();
            if (isEndOfGame()) break;
            printMap();

        }
        printMap();
    }

}
