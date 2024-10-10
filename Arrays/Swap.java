import java.util.Scanner;
import java.util.Arrays;

public class Swap{
    public static void main(String[] args){
     int[] arr={1,2,3,4};
     swap(arr,0,2);
     System.out.println(Arrays.toString(arr));

    }

    static void  swap(int[] arr, int inx1, int inx2){
        int temp=arr[inx1];
        arr[inx1]=arr[inx2];
        arr[inx2]=temp;
    }
}    