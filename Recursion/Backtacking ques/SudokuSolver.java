public class SudokuSolver {

    public static void main(String[] args) {
        // A sample Sudoku board (0 represents empty cells)
        // I am using a char[][] because that is what LeetCode expects,
        // but you can easily change this to int[][] if you prefer.
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Original Board:");
        displayBoard(board);

        if (solve(board)) {
            System.out.println("\nSolved Board:");
            displayBoard(board);
        } else {
            System.out.println("\nThis board cannot be solved.");
        }
    }

    // --- THE WORKER (Backtracking Function) ---
    public static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                // If the cell is empty ('.')
                if (board[i][j] == '.') {
                    
                    // Try numbers 1 through 9
                    for (char c = '1'; c <= '9'; c++) {
                        
                        // Check if it's safe to place 'c'
                        if (isValid(board, i, j, c)) {
                            
                            // Choose
                            board[i][j] = c;
                            
                            // Explore
                            if (solve(board)) {
                                return true; // Success!
                            }
                            
                            // Undo (Backtrack)
                            board[i][j] = '.';
                        }
                    }
                    // If we try 1-9 and none work, this path is dead.
                    return false;
                }
            }
        }
        // If loops finish with no return false, board is full/solved.
        return true;
    }

    // --- THE GUARD (Validation Function) ---
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            
            // Check Row
            if (board[row][i] == c) return false;
            
            // Check Column
            if (board[i][col] == c) return false;
            
            // Check 3x3 Box (The math trick we discussed)
            int boxRowStart = 3 * (row / 3);
            int boxColStart = 3 * (col / 3);
            
            // i/3 gives row offset (0, 0, 0, 1, 1, 1, 2, 2, 2)
            // i%3 gives col offset (0, 1, 2, 0, 1, 2, 0, 1, 2)
            if (board[boxRowStart + i / 3][boxColStart + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    // --- HELPER TO PRINT THE BOARD ---
    private static void displayBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j] == '.' ? " . " : " " + board[i][j] + " ");
            }
            System.out.println();
        }
    }
}