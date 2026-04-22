
import java.util.*;
import java.util.LinkedList;

public class GridBFS {

    static void bfs(int[][] grid , int startrow , int startcol){
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        Queue<int[] > graph = new LinkedList<>();
        graph.add(new int[] { startrow , startcol});
        visited[startrow][startcol] = true;

        int[][] dir = {
                        {1, 0}, {-1, 0}, {0, 1}, {0, -1}


        };

        while(!graph.isEmpty()){
            int[] cell = graph.poll();
            int r = cell[0];
            int c = cell[1];
            System.out.println(r + " " + c);

            for(int[] d : dir){
                int newR = r + d[0];
                int newC= c + d[1];

                if(newR >=0 && newC >=0 && newR< row && newC< col && !visited[newR][newC] ){
                    graph.add(new int[]{newR, newC});
                    visited[newR][newC] = true;


                }
            }

            

        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0},
            {0, 1, 1},
            {1, 0, 1}
        };

        bfs(grid, 0, 0);
    }
    
}
