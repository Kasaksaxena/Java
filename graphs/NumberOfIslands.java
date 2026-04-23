import java.util.*;
import java.util.LinkedList;

public class NumberOfIslands {

    static   int bfsforisland(char[][] grid ){
        int row = grid.length;
        int col = grid[0].length;
        int count = 0 ;
        int[][] dir ={
                        {1, 0}, {-1, 0}, {0, 1}, {0, -1}

        };
        
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0 ; i< row ; i++){
            for(int j=0 ; j< col ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count ++;
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        for( int[]  d : dir){
                            int newr = r + d[0];
                            int newc = c + d[1];
                            if(newr>= 0 && newc>=0 && newr< row && newc< col && !visited[newr][newc] && grid[newr][newc] == '1'){
                                queue.add(new int[]{newr, newc});
                                visited[newr][newc] = true;

                            }

                        }
                    }


                }

            }


        }
        return count;



    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0'},
            {'0', '1', '1'},
            {'1', '0', '1'}
        };
        int result = bfsforisland(grid);
        System.out.println(result);

    }
    
    
}
