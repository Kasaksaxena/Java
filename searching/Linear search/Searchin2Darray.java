
import java.lang.reflect.Array;
import java.util.Arrays;

public class Searchin2Darray{
    public static void main(String[] args) {
        int[][] arr={
                {2,4,1},
                {18,12,3,9},
                {78,99,34,56},
                {27,54}
        };

        int target=56; 
        int[] Ans= search(arr,target);
        System.out.println(Arrays.toString(Ans));
    }
    static int[] search(int[][] arr,int target){
    
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[i].length;j++){
                if(arr[i][j]==target){
                    return new int[]{i,j};

                }
            }

        }
        return new int[]{-1,-1};

    }
    

}