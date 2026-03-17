import java.util.*;

public class GameOfStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        return helper(x, a, b, 0, 0);
    }

    private static int helper(int x, int[] a, int[] b, int sum, int count) {

        // exceed condition
        if (sum > x) {
            return count - 1;
        }

        // no more elements
        if (a.length == 0 && b.length == 0) {
            return count;
        }

        int ans1 = count;
        int ans2 = count;

        // take from A
        if (a.length > 0) {
            ans1 = helper(x,
                    Arrays.copyOfRange(a, 1, a.length),
                    b,
                    sum + a[0],
                    count + 1);
        }

        // take from B
        if (b.length > 0) {
            ans2 = helper(x,
                    a,
                    Arrays.copyOfRange(b, 1, b.length),
                    sum + b[0],
                    count + 1);
        }

        return Math.max(ans1, ans2);
    }

    // =========================
    // MAIN METHOD FOR TESTING
    // =========================
    public static void main(String[] args) {

        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        int maxSum = 10;

        int result = twoStacks(maxSum, a, b);

        System.out.println("Maximum elements picked: " + result);

        // Additional test cases
        int[] a2 = {1, 2, 3, 4};
        int[] b2 = {2, 2, 2};
        int maxSum2 = 7;

        System.out.println("Test Case 2: " + twoStacks(maxSum2, a2, b2));

        int[] a3 = {10, 20};
        int[] b3 = {5, 5, 5};
        int maxSum3 = 10;

        System.out.println("Test Case 3: " + twoStacks(maxSum3, a3, b3));
    }
}