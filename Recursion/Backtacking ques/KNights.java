import java.util.Arrays;

 public class KNights{
    public static void main(String[] args) {
        int n = 4; // Let's solve for a 4x4 board
        solveNKnights(n);
    }

    /**
     * This is the "driver" function.
     * It creates the board and calls the recursive "worker" function.
     */
    public static void solveNKnights(int n) {
        boolean[][] board = new boolean[n][n];
        
        // Start the recursive process at the first cell (0, 0)
        // with 'n' knights left to place.
        knights(board, 0, 0, n);
    }

    /**
     * This is the "WORKER" function (recursive backtracking).
     *
     * @param board The chessboard
     * @param row   The current row we are checking
     * @param col   The current column we are checking
     * @param knightsLeft The number of knights we still need to place
     */
    private static void knights(boolean[][] board, int row, int col, int knightsLeft) {
        
        // --- BASE CASE (Success) ---
        // If we have 0 knights left to place, we've found a solution!
        if (knightsLeft == 0) {
            displayBoard(board);
            System.out.println();
            return; // Stop this path
        }

        // --- BASE CASE (Out of Bounds) ---
        // If we've run out of rows, we can't place any more.
        if (row == board.length) {
            return; // Backtrack
        }

        // --- Cell Iteration Logic ---
        // If 'col' is at the end of the row, move to the next row.
        if (col == board.length) {
            knights(board, row + 1, 0, knightsLeft); // Note: col resets to 0
            return; // Stop this path, as we've explored it in the call above
        }

        // --- RECURSIVE STEP (The 2 Choices) ---
        
        // Choice 1: Place a knight at (row, col)
        // First, check if it's safe.
        if (isSafe(board, row, col)) {
            // 1a. CHOOSE: Place the knight
            board[row][col] = true;
            
            // 1b. EXPLORE: Move to the next cell (row, col + 1)
            //    We now have 'knightsLeft - 1' knights to place.
            knights(board, row, col + 1, knightsLeft - 1);
            
            // 1c. UNDO (BACKTRACK): Remove the knight to explore
            //    the other choice (skipping this cell).
            board[row][col] = false;
        }

        // Choice 2: Skip this cell (row, col)
        //    (This happens whether or not it was safe)
        // 2a. EXPLORE: Move to the next cell (row, col + 1)
        //    We still have 'knightsLeft' knights to place.
        knights(board, row, col + 1, knightsLeft);
    }

    /**
     * This is the "GUARD" function.
     * Checks if placing a knight at (row, col) is safe.
     * We only need to check the 4 "upward" spots.
     */
    private static boolean isSafe(boolean[][] board, int row, int col) {
        
        // Check 1: Up 2, Left 1
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        
        // Check 2: Up 2, Right 1
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        
        // Check 3: Up 1, Left 2
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        
        // Check 4: Up 1, Right 2
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        
        // If all 4 spots are safe, return true
        return true;
    }

    /**
     * Helper "GUARDRAIL" function.
     * Checks if a (row, col) coordinate is on the board.
     * Prevents IndexOutOfBoundsException.
     */
    private static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    // Helper function to print the board
    private static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                if (cell) {
                    System.out.print("K "); // K for Knight
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

