
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappMissNum{
 public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        Cyclesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static List<Integer> Cyclesort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]==arr[correct]){
                i++; 
                }
            else{
                swap(arr,i,correct);
            
            } 
        } 
            // find missing nums
            List<Integer> ans=new ArrayList<>();
            for(int index=0;index<arr.length;index++){
                if(arr[index]!=index+1){
                    ans.add(index+1);
                    System.out.println(ans);
                
                }

            }  
        return ans;
        }
        
    

    static void swap(int[]arr , int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}