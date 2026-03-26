import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            // count frequency
            map.put(num, map.getOrDefault(num, 0) + 1);

            // check majority condition
            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // not needed (problem guarantees answer)
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums)); // 2
    }
}