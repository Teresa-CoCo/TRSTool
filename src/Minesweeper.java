import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int NUM_MINES = 10;
    private static char[][] board = new char[WIDTH][HEIGHT];
    private static boolean[][] revealed = new boolean[WIDTH][HEIGHT];
    private static boolean[][] flagged = new boolean[WIDTH][HEIGHT];

    public static void start() {
        initializeBoard();
        placeMines();
        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;
        while (!gameOver) {
            printBoard();
            System.out.println("Enter row and column to reveal (r c), or 'f' to toggle flag (r c f):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            String next = scanner.hasNext() ? scanner.next() : "";
            if ("f".equals(next)) {
                toggleFlag(row, col);
            } else {
                gameOver = revealCell(row, col);
                if (checkWin()) {
                    System.out.println("Congratulations! You've cleared all the mines!");
                    break;
                }
            }
            if (gameOver) {
                System.out.println("Game Over! You hit a mine!");
                printBoard(true);
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                board[i][j] = '-';
                revealed[i][j] = false;
                flagged[i][j] = false;
            }
        }
    }

    private static void placeMines() {
        Random random = new Random();
        for (int i = 0; i < NUM_MINES; i++) {
            int row, col;
            do {
                row = random.nextInt(WIDTH);
                col = random.nextInt(HEIGHT);
            } while (board[row][col] == '*');
            board[row][col] = '*';
        }
    }

    private static void printBoard() {
        printBoard(false);
    }

    private static void printBoard(boolean showMines) {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (showMines && board[i][j] == '*') {
                    System.out.print("* ");
                } else if (flagged[i][j]) {
                    System.out.print("F ");
                } else if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private static boolean revealCell(int row, int col) {
        if (row < 0 || row >= WIDTH || col < 0 || col >= HEIGHT || revealed[row][col] || flagged[row][col]) {
            return false;
        }

        revealed[row][col] = true;

        if (board[row][col] == '*') {
            return true;
        }

        int mineCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i, c = col + j;
                if (r >= 0 && r < WIDTH && c >= 0 && c < HEIGHT && board[r][c] == '*') {
                    mineCount++;
                }
            }
        }

        board[row][col] = (char) (mineCount + '0');

        if (mineCount == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(row + i, col + j);
                }
            }
        }

        return false;
    }

    private static void toggleFlag(int row, int col) {
        if (row < 0 || row >= WIDTH || col < 0 || col >= HEIGHT || revealed[row][col]) {
            return;
        }
        flagged[row][col] = !flagged[row][col];
    }

    private static boolean checkWin() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (board[i][j] != '*' && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

