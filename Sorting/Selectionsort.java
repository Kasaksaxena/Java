
import java.util.Arrays;

public class Selectionsort{
    public static void main(String[] args) {
        int[] arr={4,2,5,1,3};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for(int i=0; i<arr.length;i++){
  // find max index and swap it with correct index
        int last=arr.length-i-1;
        int maxindex=Max(arr,0,last);
        swap(arr,last,maxindex);
        }
    }

    static void swap(int[] arr , int first ,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }

    static int Max(int[] arr,int start,int last){
        int max=0;
        for(int i=0;i<=last;i++){
            if(arr[i]>arr[max]){
                max=i;
            }

        }
        return max;
    }
}