
import java.util.Arrays;

public class Bubblesort{
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        boolean swapped;

        for(int i=0;i<arr.length;i++){
            swapped=false;
            for(int j=1;j<arr.length-i;j++){
                // swap if item is smaller than previous one
                if(arr[j]<arr[j-1]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;


                }
            }
            // if u didnt swap for particular value of its means sorted
            
            if(!swapped){
                break;
            }

        }


    }
}