
import java.util.Arrays;

public class Merge{
    public static void main(String[] args) {
        int[] arr={1,3,9,5,6,4};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }

    static int[] mergeSort(int[] arr){
        if(arr.length ==1){
            return arr;
        }
        int mid=arr.length/2;

        int[] left= mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left,int[] right){
        int[] mix= new int[left.length +right.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
            mix[k]=left[i];

            i++;
        } else {
            mix[k]=right[j];
            j++;
        }
        k++;

    }

    // may be posible one of arrays is not complete

    while(i< left.length){
        mix[k]=left[i];
        i++;
        k++;
    }
    while(j <right.length){
        mix[k]=right[j];
        j++;
        k++;
    }

    return mix;
    }
}