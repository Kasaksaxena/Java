import java.util.*;

public class CycleDetectionDirectedDFS {
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];
        boolean[] restack = new boolean[V];

        for(int i = 0; i < V; i++){

            if(!visited[i]){
                if (dfs(adj , visited , i , restack)) {
                    return true;
                }
            }
        }
        return false;

    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited ,int node , boolean[] restack){

        visited[node] = true;
        restack[node] = true;

       for(int neigh : adj.get(node)){
        if(!visited[neigh]){
            if(dfs(adj , visited , neigh , restack)){
                return true;
            }
        }else if(restack[neigh] ){
            return true;
        }


       }
       restack[node] = false;
       return false;


    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 0-1, 1-2, 2-3, 3-0 (cycle)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        boolean hasCycle = hasCycle( adj , V);
        System.out.println("Cycle exists: " + hasCycle);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    
}
