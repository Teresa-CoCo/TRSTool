package cocloud.teresacoco.life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GUIMinesweeper extends JFrame {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;
    private final int NUM_MINES = 10;
    private JButton[][] buttons = new JButton[WIDTH][HEIGHT];
    private boolean[][] mines = new boolean[WIDTH][HEIGHT];
    private boolean[][] revealed = new boolean[WIDTH][HEIGHT];
    private boolean[][] flagged = new boolean[WIDTH][HEIGHT];

    public GUIMinesweeper() {
        setTitle("Minesweeper");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(WIDTH, HEIGHT));
        initializeButtons();
        placeMines();
    }

    private void initializeButtons() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.addActionListener(new ButtonListener(i, j));
                button.addMouseListener(new RightClickListener(i, j));
                add(button);
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < NUM_MINES) {
            int row = random.nextInt(WIDTH);
            int col = random.nextInt(HEIGHT);
            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }
    }

    private class ButtonListener implements ActionListener {
        private int row, col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!flagged[row][col]) {
                reveal(row, col);
                checkWin();
            }
        }
    }

    private class RightClickListener extends MouseAdapter {
        private int row, col;

        public RightClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                toggleFlag(row, col);
            }
        }
    }

    private void reveal(int row, int col) {
        if (row < 0 || row >= WIDTH || col < 0 || col >= HEIGHT || revealed[row][col]) return;
        revealed[row][col] = true;
        if (mines[row][col]) {
            buttons[row][col].setText("X");
            gameOver();
        } else {
            int nearbyMines = countNearbyMines(row, col);
            if (nearbyMines > 0) {
                buttons[row][col].setText(String.valueOf(nearbyMines));
            } else {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        reveal(row + i, col + j);
                    }
                }
            }
        }
    }

    private int countNearbyMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < WIDTH && c >= 0 && c < HEIGHT && mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void toggleFlag(int row, int col) {
        if (!revealed[row][col]) {
            flagged[row][col] = !flagged[row][col];
            buttons[row][col].setText(flagged[row][col] ? "F" : "");
        }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over!");
        System.exit(0);
    }

    private void checkWin() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (!mines[i][j] && !revealed[i][j]) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "You win!");
        System.exit(0);
    }

    public static void start() {
        SwingUtilities.invokeLater(() -> {
            GUIMinesweeper game = new GUIMinesweeper();
            game.setVisible(true);
        });
    }
}
