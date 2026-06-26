import java.util.*;

public class SecondLargest {

    public static int secondLargest(int[] nums) {

        if (nums.length < 2) {
            return -1;
        }

        Integer first = null;
        Integer second = null;

        for (int num : nums) {

            if (first == null || num > first) {
                second = first;
                first = num;
            }
            else if (num != first && (second == null || num > second)) {
                second = num;
            }
        }

        return (second == null) ? -1 : second;
    }

    public static void main(String[] args) {

        int[] nums = {12, 35, 1, 10, 34, 1};

        int ans = secondLargest(nums);

        if (ans == -1) {
            System.out.println("Second largest element does not exist.");
        } else {
            System.out.println("Second largest element: " + ans);
        }
    }
}