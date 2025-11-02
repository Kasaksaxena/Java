

public class Leetcode26 {
     

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;  // slow pointer

        for (int j = 1; j < nums.length; j++) { // fast pointer
            if (nums[j] != nums[i]) {
                i++;                 // move slow pointer
                nums[i] = nums[j];   // update unique value
            }
        }

        return i + 1; // new length of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4};

        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);

        System.out.print("Modified array: ");
        for (int k = 0; k < newLength; k++) {
            System.out.print(nums[k] + " ");
        }
    }
}
    
