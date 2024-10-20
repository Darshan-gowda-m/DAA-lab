package Darshan;

import java.util.Scanner;

public class NQueen {
    int N; // Size of the chessboard
    boolean hasSolution; // Flag to check if at least one solution exists

    // Method to print the solution in a clear format
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println(); // Print an empty line between solutions
    }

    boolean isSafe(int board[][], int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    // Modified to find all solutions
    void solveNQUtil(int board[][], int col) {
        if (col >= N) {
            printSolution(board); // Print the board when a solution is found
            hasSolution = true; // Set flag to true if a solution is found
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen
                solveNQUtil(board, col + 1); // Recur to place rest of the queens
                board[i][col] = 0; // BACKTRACK
            }
        }
    }

    void solveNQ() {
        int board[][] = new int[N][N];
        hasSolution = false; // Reset the flag for each board size
        solveNQUtil(board, 0);

        // Print message if no solution is found
        if (!hasSolution) {
            System.out.println("No solutions exist for N = " + N);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board sizes (space-separated, e.g., 4 5):");
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        for (String str : inputs) {
            NQueen queen = new NQueen();
            queen.N = Integer.parseInt(str);
            System.out.println("All solutions for N = " + queen.N + ":");
            queen.solveNQ();
            System.out.println("----------------------------------");
        }
        scanner.close();
    }
}
