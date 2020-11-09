package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            move(e.getSource());
        }
    }

    private final JButton[][] gameField = new JButton[4][4];
    private final int[] intGameField = new int[16];
    private JLabel counter;
    private int moveCount;
    private int zeroX, zeroY;
    private boolean inGame;
    private int countOfValid;

    private void addButtons() {

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        JPanel menu = new JPanel();
        add(menu, BorderLayout.WEST);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuffleButtons();
            }
        });
        menu.add(newButton);

        JPanel footer = new JPanel();
        counter = new JLabel("Move : 0");
        add(footer, BorderLayout.SOUTH);
        footer.add(counter);

        MyMouseListener listener = new MyMouseListener();

        panel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = new JButton("");
                panel.add(gameField[i][j]);
                gameField[i][j].addMouseListener(listener);
                int count = i * 4 + j;
                intGameField[count] = count;
            }
        }
    }

    private void shuffleButtons() {

        countOfValid = 0;
        inGame = true;
        moveCount = 0;

        for (int i = intGameField.length - 1; i > 0; i--) {
            int r = (int) (Math.random() * i);
            if (r != i) {
                int temp = intGameField[i];
                intGameField[i] = intGameField[r];
                intGameField[r] = temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int count = i * 4 + j;
                if (intGameField[count] == 0) {
                    gameField[i][j].setText("");
                    zeroX = i;
                    zeroY = j;
                } else {
                    gameField[i][j].setText("" + intGameField[count]);
                    if (intGameField[count] == count + 1) countOfValid++;
                }
            }
        }

        showInfoAndCheckWin();
    }

    private void initField() {

        addButtons();
        shuffleButtons();

    }

    private void showInfoAndCheckWin() {
        if (countOfValid == 15) inGame = false;
        counter.setText(String.format("Move: %1$5d     |     Valid cells: %2$2d     |     %3$s",
                moveCount, countOfValid, inGame ? "" : "YOU WIN!!!"));
    }

    private void move(Object source) {
        if (source instanceof JButton && inGame) {
            moveCount++;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) != 1) continue;
                    if (zeroX + i < 0 || zeroX + i > 3 || zeroY + j < 0 || zeroY + j > 3) continue;
                    if (gameField[zeroX + i][zeroY + j] == source) {

                        int goalIndex = (zeroX + i) * 4 + zeroY + j;
                        int zeroIndex = zeroX * 4 + zeroY;
                        if (intGameField[goalIndex] == zeroIndex + 1) countOfValid++;
                        if (intGameField[goalIndex] == goalIndex + 1) countOfValid--;
                        intGameField[zeroIndex] = intGameField[goalIndex];
                        intGameField[goalIndex] = 0;

                        gameField[zeroX][zeroY].setText("" + intGameField[zeroIndex]);
                        zeroX += i;
                        zeroY += j;
                        gameField[zeroX][zeroY].setText("");
                        showInfoAndCheckWin();
                        return;
                    }
                }
            }
            showInfoAndCheckWin();
        }
    }

    public MainWindow() throws HeadlessException {

        setTitle("15 Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 350, 300);

        initField();

        setVisible(true);
    }
}
