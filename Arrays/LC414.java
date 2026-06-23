public class LC414 {

    public static int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            if ((first != null && num == first) ||
                (second != null && num == second) ||
                (third != null && num == third)) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            } else if (second == null || num > second) {
                third = second;
                second = (long) num;
            } else if (third == null || num > third) {
                third = (long) num;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 2, 3, 1};

        System.out.println(thirdMax(nums1)); // 1
        System.out.println(thirdMax(nums2)); // 2
        System.out.println(thirdMax(nums3)); // 1
    }
}