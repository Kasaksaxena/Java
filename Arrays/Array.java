import java.util.Scanner;
import java.util.Arrays;

public class Array{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr= new int[5];
        // Input using for loops
        for(int i=0; i<arr.length;i++){
            arr[i]=in.nextInt();
        }

            // Arrays.toString() method
            System.out.println(Arrays.toString(arr));
        

        //enhanced for loop
        //for(int num:arr){
        //   System.out.print(num + " ");
        //}
    }
}