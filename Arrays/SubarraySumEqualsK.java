// leetcode 560
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int [] arr={1,1,1};
        int k=2;
        Solution sol=new Solution();
        System.out.println("Count=" + sol.subarraySum(arr,k));
    }
}

    class Solution{
        public int subarraySum(int[] arr, int k){
            Map<Integer,Integer> prefixSumFreq= new HashMap<>();
            prefixSumFreq.put(0,1);// base case :one subarray with sum=0
            int prefixSum=0 , count=0;
            for( int num : arr){
               prefixSum +=num;
               if(prefixSumFreq.containsKey(prefixSum-k)){
                count +=prefixSumFreq.getOrDefault(prefixSum-k,0);
               }
               prefixSumFreq.put(prefixSum,prefixSumFreq.getOrDefault(prefixSum, 0)+1);
               //prefixSumFreq.getOrDefault(prefixSum,0 ) returns frequency of prefixsum ,if not present ,return 0
               // + 1 You are saying i have seen this prefixSum one more time
               //.put(prefixSum,value) update the map with incremented frequency

            }
            return count;
        }
    }
    
