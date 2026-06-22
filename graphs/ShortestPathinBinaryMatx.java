import java.util.*;
import java.util.LinkedList;
public   class ShortestPathinBinaryMatx {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1){
            return -1;
        }

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});
        visited[0][0] = true;

        int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},{1,1},{1,-1},{-1,1},{-1,-1}

        };

        while(!q.isEmpty()){
            int[] cell = q.poll();
            count++;

            int r = cell[0];
            int c = cell[1];
            int distance = cell[2];
          
            if(r == row-1 && c == col-1){
                return distance;
            }
            for(int[] d : dir){
                int newr = r + d[0];
                int newc = c  + d[1];

                if(newr >=0  &&  newc >= 0 && newr < row &&  newc < col && !visited[newr][newc] && grid[newr][newc] == 0){
                    q.offer(new int[] { newr , newc, distance + 1});
                    visited[newr][newc] = true;
                }

            }




        }
        return -1;
        
    }
        public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 0, 0}
        };

        int answer = shortestPathBinaryMatrix(grid);

        System.out.println(answer);
    }

}

    
    

