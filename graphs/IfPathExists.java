import java.util.*;
public class IfPathExists {
    public  static boolean validPath(int n, int[][] edges, int source, int destination) {
        int V = n;
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i < V; i++){
            adj.add(new ArrayList<>());

        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            // optimized 
            if(node == destination) return true;
            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.offer(neigh);
                    }
            }
        }
        return false;
        
    }
        public static void main(String[] args) {


        // Test Case 1
        int n1 = 3;
        int[][] edges1 = {
            {0, 1},
            {1, 2},
            {2, 0}
        };
        int source1 = 0;
        int destination1 = 2;

        boolean result1 = validPath(n1, edges1, source1, destination1);

        System.out.println("Test Case 1:");
        System.out.println("Path exists: " + result1);
        System.out.println();

        // Test Case 2
        int n2 = 6;
        int[][] edges2 = {
            {0, 1},
            {0, 2},
            {3, 5},
            {5, 4},
            {4, 3}
        };
        int source2 = 0;
        int destination2 = 5;

        boolean result2 = validPath(n2, edges2, source2, destination2);

        System.out.println("Test Case 2:");
        System.out.println("Path exists: " + result2);
    }

    
}
