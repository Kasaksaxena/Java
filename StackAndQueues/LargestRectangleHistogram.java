import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            // Important: treat last as 0 to empty stack
            int currHeight = (i == n) ? 0 : heights[i];

            // When current is smaller → calculate area
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    // =========================
    // MAIN METHOD (TESTING)
    // =========================
    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        int result = largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area: " + result);

        // Additional test cases
        int[] test2 = {2, 4};
        System.out.println("Test 2: " + largestRectangleArea(test2));

        int[] test3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Test 3: " + largestRectangleArea(test3));
    }
}