public class Leetcode74 {

    // Function to search the target in the matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;         // number of rows
        int n = matrix[0].length;      // number of columns
        int low = 0, high = m * n - 1; // binary search range on flattened array

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert mid (1D index) to 2D (row, col)
            int row = mid / n;
            int col = mid % n;

            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; // target found
            } else if (midValue < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return false; // target not found
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3; // try changing this to 13 or 16

        boolean result = searchMatrix(matrix, target);
        System.out.println("Is target " + target + " present? " + result);
    }
}

