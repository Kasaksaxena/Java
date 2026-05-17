import java.util.*;

public class minKnightMoves {
    static int knightsteps(int V , int[] start , int[] target){
        
        boolean[][] visited = new boolean[V][V];
        int[][] dir = {
            {1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}
        };

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {start[0],start[1],0});

        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int newr = cell[0];
            int newc = cell[1];
            int steps = cell[2];

            if(newr == target[0] && newc == target[1]){
                return steps;
            }
            for(int[] d : dir ){
                int r = newr + d[0];
                int c = newc + d[1];
                
                if(r >= 0 && c >= 0 && r <  V && c < V && !visited[r][c]){
                    visited[r][c]= true;
                    q.offer(new int[] {r , c , steps + 1});
                }
            }





        }
    return -1;

    }
    public static void main (String[] args){
        int V = 8;
        int[] start = {0,0};
        int[] target = {7,7};
        int result = knightsteps(V ,start , target);
        System.out.println(result);
    }
    
}
