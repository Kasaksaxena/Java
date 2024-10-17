
import java.util.Arrays;

// Leetcode 832
public class FlipImage{
    public static void main(String[] args) {
        int[][] image={{1,1,0},{1,0,1},{0,0,0}};
        int[][] ans=flipandInvertImage(image);
        
        
        print2DArray(ans);


    
            
        }
        public static int[][] flipandInvertImage(int[][] image){
            for(int[] row:image){
                // reverse the array
                for(int i=0;i<(image[0].length+1)/2;i++){
                    // swap
                    int temp=row[i]^1;
                    row[i]=row[image[0].length-i-1]^1;
                    row[image[0].length-i-1]=temp;
                }
            }
            return image;
        }
        // print 2d array
        public static void print2DArray(int[][] image){
            for(int[] row:image){
                for(int elem:row){
                    System.out.print(elem + "");
                }
                System.out.println();
            }
        }
}
        
    