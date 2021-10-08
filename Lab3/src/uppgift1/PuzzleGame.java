/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift1;

import java.util.Scanner;

/**
 *
 * @author Johan Challita
 */
public class PuzzleGame {

    private int[][] board;
    private int size;
    private int nrOfSolutions;
    private int greyRow, greyCol;

    public PuzzleGame() {
        this.size = 5;
        this.board = new int[size][size];
        this.nrOfSolutions = 0;
        init(size);
    }

    private void init(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 0;
            }
        }
        System.out.print("Where do you want to place your grey puzzle? ");
        Scanner scan = new Scanner(System.in);
        this.greyRow = scan.nextInt();
        this.greyCol = scan.nextInt();
        board[greyRow][greyCol] = 5;

        // * *
        // *
        /* board[1][4] = 4;
        board[1][3] = 4;
        board[2][3] = 4;*/
    }

    //* 
    //* *
    public void figureOne(int row, int col, boolean remove) {
        if (remove) {
            board[row][col] = 0;
            board[row + 1][col] = 0;
            board[row + 1][col + 1] = 0;
        } else {
            board[row][col] = 1;
            board[row + 1][col] = 1;
            board[row + 1][col + 1] = 1;
        }
    }

    // 
    public void figureTwo(int row, int col, boolean remove) {
        if (remove) {
            board[row + 2][col + 1] = 0;
            board[row + 3][col] = 0;
            board[row + 3][col + 1] = 0;
        } else {
            board[row + 2][col + 1] = 2;
            board[row + 3][col] = 2;
            board[row + 3][col + 1] = 2;
        }
    }

    public void figureThree(int row, int col, boolean remove) {
        if (remove) {
            board[row][col + 1] = 0;
            board[row + 1][col + 1] = 0;
            board[row + 2][col + 2] = 0;
        } else {
            board[row][col + 1] = 3;
            board[row + 1][col + 1] = 3;
            board[row + 2][col + 2] = 3;
        }
    }

    private boolean isSafe(int board[][], int row, int col) {
        if (col + 1 < 5 && row + 1 < 5 && board[row][col + 1] != 5 && board[row][col + 1] == 0 && board[row][col] != 0) {
            figureOne(row, col, false);
        } else {
            figureOne(row, col, true);
        }
        if (col + 1 < 5 && row + 1 < 5 && board[row][col + 1] != 5 && board[row][col + 1] == 0 && board[row][col] != 0) {
            figureTwo(row, col, false);
        } else {
            figureTwo(row, col, true);
        }
        if (col + 1 < 5 && row + 1 < 5 && board[row][col + 1] != 5 && board[row][col + 1] == 0 && board[row][col] != 0) {
            figureThree(row, col, false);
        } else {
            figureThree(row, col, true);
        }
        return true;
    }

    private boolean solveProblem(int[][] board, int row) {
        if (row >= size) {
            printBoard(board);
            System.out.println();
            nrOfSolutions++;
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (isSafe(board, row, i)) {
                isSafe(board, row, i);
                solveProblem(board, row + 1);
                board[row][i] = 0; //backtracking if the queen doesn't lead to a solution
            }
        }
        printBoard(board);
        return false;
    }

    public void solveResult() {
        solveProblem(board, 0);
    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getNrOfSolutions() {
        return nrOfSolutions;
    }
}
