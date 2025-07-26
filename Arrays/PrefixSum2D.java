//leetcode 304
public class PrefixSum2D {
    int[][] prefix;

    // Constructor to compute prefix sum matrix
    public PrefixSum2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // One extra row and column to simplify boundary calculations
        prefix = new int[m + 1][n + 1];

        // Build the prefix matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = matrix[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
    }

    // Method to compute sum of a submatrix from (row1, col1) to (row2, col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        PrefixSum2D obj = new PrefixSum2D(matrix);

        // Test sumRegion from (2,1) to (4,3)
        int result = obj.sumRegion(2, 1, 4, 3);
        System.out.println("Sum of region (2,1) to (4,3): " + result);
    }
}

