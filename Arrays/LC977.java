import java.util.*;

class LC977{
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int pos = n-1;
        int slow =0;
        int fast = n-1;

        while(slow <= fast){
            if(Math.abs(nums[slow]) > Math.abs(nums[fast])){
                arr[pos] = nums[slow] *nums[slow];
                slow++;
                pos--;

            }else{
                arr[pos] = nums[fast] *nums[fast];
                fast--;
                pos--;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        int[] nums = {-4,-1,0,3,10};
        int[] ans;
        ans  = sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }
}