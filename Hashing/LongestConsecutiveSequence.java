import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        // Edge case
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Traverse set
        for (int num : set) {

            // Only start if it's the beginning of sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                // Expand forward
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {10, 5, 12, 3, 55, 11, 4};

        System.out.println("Output 1: " + longestConsecutive(nums1)); // 4
        System.out.println("Output 2: " + longestConsecutive(nums2)); // 3
    }
}