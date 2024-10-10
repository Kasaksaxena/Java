
import java.util.Arrays;

public class f_lPosn{
    public static void main(String[] args) {
        int[] arr={5,7,7,7,8,8,10};
        int target=7;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
    static int[] searchRange(int[]arr,int target){
        int [] ans={-1,-1};
        int start=Binarysearch(arr, target, true);
        int end=Binarysearch(arr, target, false);

        ans[0]=start;
        if(ans[0]!=-1){
         ans[1]=end;
        }
        return ans;
    }

    static int Binarysearch(int[] arr,int target,boolean findstartindex){
        int ans=-1;
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target>arr[mid]){
                start=mid+1;    
            }
            else if(target<arr[mid]){
                end=mid-1;  
            }
            else{
                ans=mid;
                if(findstartindex==true){
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                   
                }
            }
    
        }
        return ans;
    }

}