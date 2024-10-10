
// leetcode Q1672.Richest Customer Wealth
public class MaxWealth{
    public static void main(String[] args) {
        
    }
    public int maxwealth(int[][] accounts){
        
        int ans=Integer.MIN_VALUE;
        for (int[] account1 : accounts) {
            int sum=0;
            for (int account = 0; account < account1.length; account++) {
                sum += account1[account];
            }
            if(sum>ans){
                ans=sum;
            }
        }
        return ans;
    }
}