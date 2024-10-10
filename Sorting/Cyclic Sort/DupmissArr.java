
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DupmissArr{
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        
         System.out.println(Cyclesort(arr));
       
        
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
            List<Integer> ans=new ArrayList<>();
            for(int index=0;index<arr.length;index++){
                if(arr[index]!=index+1){
                     ans.add(arr[index]);
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
 
