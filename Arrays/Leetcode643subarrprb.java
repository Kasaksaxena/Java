public class Leetcode643subarrprb {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(sol.findMaxAverage(nums, k)); // Output: 12.75

    }
}
    class Solution{
        public double findMaxAverage(int[] nums,int k){
            double maxsum=Integer.MIN_VALUE,sum=0;

            for(int i=0;i<k;i++){
                sum+= nums[i];
            }
            maxsum=sum;
            for(int i=k;i<nums.length;i++){
                sum +=nums[i]-nums[i-k];
                maxsum=Math.max(maxsum,sum);
            }
            return maxsum/k;
        }
    }
    

