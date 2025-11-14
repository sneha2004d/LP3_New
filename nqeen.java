public class NQueen {

    static int N = 4; // size of chessboard


    // Function to print the chessboard
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }`

    // Check if placing queen at board[row][col] is safe
    static boolean isSafe(int[][] board, int row, int col) {
        // Check this column on upper side
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve N-Queen using backtracking
    static boolean solveNQueen(int[][] board, int row) {
        if (row == N) { // all queens placed
            printBoard(board);
            return true;
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen
                res = solveNQueen(board, row + 1) || res; // place next
                board[row][col] = 0; // backtrack
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (!solveNQueen(board, 0))
            System.out.println("No solution exists");
    }
}
