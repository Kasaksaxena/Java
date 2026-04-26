import java.util.*;
import java.util.LinkedList;


public class Matrix01{

    static int[][] matrix01(int[][] grid){
        int row= grid.length;
        int col = grid[0].length;

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        Queue<int[]> graph = new LinkedList<>();
        // Step 1: Add all 0s to queue & mark 1s as -1

        for(int i = 0; i<row ; i++){
          for(int j = 0; j<col ; j++){
            if(grid[i][j] == 0){
                graph.add(new int[] {i,j});
            }else if(grid[i][j] == 1){
                grid[i][j] = -1;
            }
          }

        }
        // Step 2: BFS

        while(!graph.isEmpty()){
            int[] cell = graph.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir ){
                int newr = r + d[0];
                int newc= c + d[1];

                if(newr >= 0 && newc >= 0 && newr < row && newc < col && grid[newr][newc] == -1){
                    grid[newr][newc] = grid[r][c] + 1;
                    graph.add(new int[] {newr, newc});
                }

            }

        }



       return grid; 

    }

    public static void main(String[] args){
        int[][] grid ={
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        int[][] result= matrix01(grid);

        for(int[] row : result){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}