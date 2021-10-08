package uppgift6;

/**
 *
 * @author Johan Challita
 */
public class QueenSolver {

    private int[][] board;
    private int size;
    private int nrOfSolutions;

    public QueenSolver(int n) {
        this.size = n;
        this.board = new int[size][size];
        this.nrOfSolutions = 0;
        initBoard(size);
    }

    private void initBoard(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    private boolean isSafe(int board[][], int row, int col) {
        //check if two queens are in same col
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        //check if two queens share same \ diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if two queens share same / diagonal
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean solveProblem(int board[][], int row) {
        //Base check: Checks if all queens are in place
        if (row >= size) {
            printBoard(board);
            System.out.println();
            nrOfSolutions++;
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (isSafe(board, row, i)) {
                this.board[row][i] = 1;
                solveProblem(board, row + 1);
                board[row][i] = 0; //backtracking if the queen doesn't lead to a solution
            }
        }
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

    public int getSize() {
        return size;
    }

    public int getNrOfSolutions() {
        return nrOfSolutions;
    }
}
