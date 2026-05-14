import java.util.*;
public class largestPathValue{
    public static int largestPath(String colors, int[][] edges) {
        int V = colors.length();
        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // graph 
        for(int i =0; i <V; i++){
            adj.add(new ArrayList<>());

        }
        for(int[] edge : edges){
            int u =edge[0] ;
            int v =edge[1] ;
            adj.get(u).add(v);
            indegree[v]++;

        }
        
        // // dp[node][color]
        int[][] dp = new int[V][26];

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i]== 0){
                q.offer(i);
                 // its own color count becomes 1
                 int color = colors.charAt(i) - 'a';
                 dp[i][color] = 1;

            }
        }
        int visited = 0;
        int answer = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            visited++;

            // global max ans
            for(int c =0; c < 26; c++){
                answer= Math.max(answer , dp[node][c]);
            }

            // traverse
            for(int neigh : adj.get(node)){
                int neighcolor = colors.charAt(neigh) - 'a';

                // dp optimise
                for(int c =0; c <26;c++){
                    int extra = (c == neighcolor)?1:0;
                    dp[neigh][c] = Math.max(dp[neigh][c] , dp[node][c] + extra);

                }
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }



    return visited == V ?answer :-1;
        
    }
        public static void main(String[] args) {


        // Example graph
        String colors = "abacaba";

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3},
            {2, 4},
            {3, 5},
            {4, 5},
            {5, 6}
        };

        int result = largestPath(colors, edges);

        System.out.println("Largest Path Value = " + result);
    }




}