import java.util.*;

public class Leetcode340Premium{
    public static void main(String[] args) {
        String s="eceba";
        int k=2;
        Solution sol=new Solution();
        System.out.println("Length of Longest Substring k Disntinct:" + sol.lengthofString(s,k));

    }
}
class Solution{
    public  int lengthofString(String s, int k){
        if(k==0 || s.length()==0)return 0;
        Map<Character,Integer> map=new HashMap<>();
        int maxLen=0, left=0;
        for(int right=0; right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);

            while(map.size()>k){
                char leftchar=s.charAt(left);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;

    }
}