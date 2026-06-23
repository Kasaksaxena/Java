import java.util.*;
public class LC1631 {

    static class Cell {
        int row ;
        int col ;
        int effort;

        Cell(int row , int col , int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    static int maximumEffortPath(int[][] heights){
        int rows = heights.length;
        int cols =heights[0].length;
        int[][] efforts = new int[rows][cols];

        for(int i =0; i <rows; i++){
            Arrays.fill(efforts[i] , Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(
        (a,b) -> a.effort - b.effort
        );

        efforts[0][0] =0;
        pq.offer(new Cell(0,0,0));
        int[][] dir={
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while(!pq.isEmpty()){
            Cell current = pq.poll();
            int r = current.row;
            int c = current.col ;
            int curreffort = current.effort;

            if(r == rows -1  && c == cols -1){
                return curreffort;
            }

            if(curreffort > efforts[r][c]){
                continue;
            }

            for(int[] d : dir){
                int newr = r + d[0];
                int newc = c + d[1];

                if(newr >=0 && newc >= 0 && newr < rows && newc < cols ){
                    int edgeeffort = Math.abs(heights[r][c] -  heights[newr][newc]);
                    int neweffort = Math.max(curreffort , edgeeffort);

                    if(neweffort < efforts[newr][newc]){
                        efforts[newr][newc] = neweffort;
                        pq.offer(new Cell ( newr ,newc , neweffort));
                    }
                }

            }
        }
    return 0;  
    }

       public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        int answer = maximumEffortPath(heights);

        System.out.println(answer);
    }

    
}
