public class PrefixSum {
    public static void main(String[] args) {
        // Given array
        int[] nums = {-2, 0, 3, -5, 2, -1};

        // Create object of NumArray
        NumArray obj = new NumArray(nums);

        // Test queries
        System.out.println("sumRange(0, 2): " + obj.sumRange(0, 2)); // Output: 1
        System.out.println("sumRange(2, 5): " + obj.sumRange(2, 5)); // Output: -1
        System.out.println("sumRange(0, 5): " + obj.sumRange(0, 5)); // Output: -3
    }
}

// Leetcode 303: Range Sum Query – Immutable
class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[n + 1];  // prefix[0] = 0
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
    

