import java.util.Scanner;
import java.util.Arrays;

public class Max{
    public static void main(String[] args){
        int[] arr= {12,47,13,56,84,25,7};

        System.out.println(ArrMax(arr));
    }

    static int ArrMax(int[] arr){
        int maxval=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxval){
                maxval=arr[i];
            }


        }
        return maxval;

    } 
}