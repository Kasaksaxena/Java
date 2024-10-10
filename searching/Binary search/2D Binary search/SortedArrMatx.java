
import java.lang.reflect.Array;
import java.util.Arrays;

public class SortedArrMatx{
    public static void main(String[] args) {
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,18,19}
        };
        int target=11;
        
        System.out.println(Arrays.toString(findpotentialrow(arr,target)));
        
        
            
        }


    
    static int[] findpotentialrow(int[][] arr,int target){
        int row_L=arr[0].length;// total elmt in first row
        int col_L=arr.length;//  length of last col 

        int lb=0;
        int ub=col_L-1;
        while(lb<ub){
            int mid=lb+(ub-lb)/2;
            
            if(arr[mid][col_L-1]<target){
                lb=mid+1;

            }
            else if(arr[mid][col_L-1]>target){
                ub=mid;
            }
            else{// reach case ub=lb
            return new int[]{mid,col_L-1};

            }
        }
        int ind=Binarysearch(arr[lb],target);
            if(ind!=-1){
                return new int[]{lb,ind};

            }

        
        return new int[]{-1,-1};
    }
    
    static int Binarysearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        

        while(start<=end){
            int mid= start +(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

    

    

