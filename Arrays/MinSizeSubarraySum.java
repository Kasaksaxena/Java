public class MinSizeSubarraySum {
    public static void main(String[] args){
        int[] arr={2,3,1,2,4,3};
        int target=7;
        int length=minSizeSubarray(arr,target);
        System.out.println("Min Size Subarray Sum:" + length);
    }
    public static int minSizeSubarray(int[] arr,int target){
        int left=0;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        for(int right=0; right<arr.length;right++){
            sum +=arr[right];

            while(sum>= target){
                minlen=Math.min(minlen,right-left+1);
                sum -=arr[left];
                left++;
            }

        }
        return (minlen==Integer.MAX_VALUE)?0:minlen;
    }
}
