import java.util.Scanner;
import java.util.Arrays;

public class TDarray{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] arr=new int[3][2];

    // Input of array
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=in.nextInt();
            }
        }
        //OUTPUT of array 
        //for(int i=0;i<arr.length;i++){
         //       System.out.println(Arrays.toString(arr[i]));
            
        //}

        // enhanced for loop

        for(int[] a:arr){
            System.out.println(Arrays.toString(a));

        }
          
    }
}