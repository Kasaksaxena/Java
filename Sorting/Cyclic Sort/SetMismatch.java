
import java.util.Arrays;

public class SetMismatch{
    public static void main(String[] args){
        int[] arr={4,2,1,3,2,6};
        System.out.println(Arrays.toString(Cyclesort(arr)));
    }
    static int[] Cyclesort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);

            }else{
                i++;
            }
        }
            System.out.println(Arrays.toString(arr));
            for(int index =0;index<arr.length;index++){
                System.out.println(arr[index]);
                if(arr[index]!=index+1){
                    return new int[]{arr[index],index+1};

                }
            }
        
        return new int[]{-1,-1};
    }
    static void swap(int[]arr , int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    

}