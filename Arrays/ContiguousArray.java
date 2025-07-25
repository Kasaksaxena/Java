//letcode 525
import java.util.*;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Important base case

        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 1, 0};  // Sample input
        System.out.println("Max Length = " + findMaxLength(nums));  // Output should be 6
    }
}