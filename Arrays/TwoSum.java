
import java.util.Arrays;
import java.util.HashMap;

//leetcode 1
public class TwoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twosum(nums,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twosum(int[] nums,int target){
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i< nums.length;i++){
            int complement=target-nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};

            }
            map.put(nums[i],i);

        }
        return new int[] {};
    }
    
}
