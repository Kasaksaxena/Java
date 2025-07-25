// leetcode 724
// concept
// leftsum== rightsum
//leftsum=total-rightsum-nums[i]
//leftsum=total-leftsum-nums[i]
// total=2 * leftsum-nums[i]



public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        
        int pivotIndex = findPivotIndex(nums);
        System.out.println("Pivot Index: " + pivotIndex);
    }

    // Function to find the pivot index
    public static int findPivotIndex(int[] nums) {
        int totalSum = 0;
        
        // Step 1: Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        
        // Step 2: Loop to check for pivot index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i; // Found the pivot
            }
            
            leftSum += nums[i]; // Update left sum
        }

        return -1; // No pivot index found
    }
}