import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public boolean isWinner() {
    char winner = (currentPlayer == 'X') ? 'O' : 'X'; // Get the previous player's mark
    // Check rows and columns for a winner
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == winner && board[i][1] == winner && board[i][2] == winner) {
            return true;
        }
        if (board[0][i] == winner && board[1][i] == winner && board[2][i] == winner) {
            return true;
        }
    }
    // Check diagonals for a winner
    if ((board[0][0] == winner && board[1][1] == winner && board[2][2] == winner) || (board[0][2] == winner && board[1][1] == winner && board[2][0] == winner)) {
        return true;
    }
    return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
        game.printBoard();
        System.out.println("Player " + game.currentPlayer + "'s turn. Enter row and column:");
        row = scanner.nextInt();
        col = scanner.nextInt();
        game.makeMove(row, col);
        if (game.isWinner()) {
            game.printBoard();
            System.out.println("Player " + ((game.currentPlayer == 'X') ? 'O' : 'X') + " wins!");
            break;
        } else if (game.isBoardFull()) {
            game.printBoard();
            System.out.println("It's a draw!");
            break;
        }
        game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
