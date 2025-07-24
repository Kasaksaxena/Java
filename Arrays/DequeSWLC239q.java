

import java.util.*;

public class DequeSWLC239q {

    public static void main(String[] args) {
        // Test input
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Create an object of Solution class
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);

        // Print result
        System.out.println("Maximums of each sliding window:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Static nested class for solving the problem
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) return new int[0];

            int n = nums.length;
            int[] result = new int[n - k + 1]; // Array to store result
            Deque<Integer> dq = new ArrayDeque<>(); // Deque to store indices

            for (int i = 0; i < n; i++) {
                // Step 1: Remove indices that are out of the current window
                // If the leftmost index is outside the window, remove it
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    System.out.println("Removed index " + dq.peekFirst() + " from front (out of window)");
                    dq.pollFirst();
                }

                // Step 2: Remove indices from the back if their corresponding values
                // are less than nums[i], since they cannot be maximum in this window
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    System.out.println("Removed index " + dq.peekLast() + " from back (smaller than " + nums[i] + ")");
                    dq.pollLast();
                }

                // Step 3: Add current index to the deque
                dq.offerLast(i);
                System.out.println("Added index " + i + " to deque");

                // Step 4: Start adding maximums to result once we have the first full window
                if (i >= k - 1) {
                    // Front of deque has the index of max element for current window
                    result[i - k + 1] = nums[dq.peekFirst()];
                    System.out.println("Window [" + (i - k + 1) + " to " + i + "] -> max: " + nums[dq.peekFirst()]);
                }
            }

            return result;
        }
    }
}