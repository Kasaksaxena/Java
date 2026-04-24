import java.util.*;
import java.util.LinkedList;
public class orangesRotting {
    static int  oranges(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int freshcount = 0;
        int minutes =0;
        int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        Queue<int[]> graph = new LinkedList<>();
        for(int i = 0 ; i<row ; i++){
        for(int j = 0 ; j<col ; j++){
            if(grid[i][j] == 2){
                graph.add(new int[]{i,j});

            }else if(grid[i][j] == 1){
                freshcount++;
            }
        }

        }

        while(!graph.isEmpty() && freshcount > 0){
            int size = graph.size();

            for(int i = 0 ; i< size ; i++){
            int[] cell = graph.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir){
               int  newr = r + d[0];
               int  newc = c + d[1];

               if(newr >= 0 && newc >=0 && newr < row && newc < col && grid[newr][newc] == 1){
                grid[newr][newc] = 2;
                graph.add(new int[]{newr,newc});
                freshcount--;

               }

            }

        }
        minutes++;
    }

        
        return (freshcount == 0)? minutes : -1;


    }
        public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(oranges(grid)); // Output: 4
    }



    
}
