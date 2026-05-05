import java.util.*;
import java.util.LinkedList;
public class CycleDetectionBFS {

    static boolean isCycle(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];

        
        for(int i =0; i < V; i ++){
            if(bfs(adj,visited , i )) return true;
        }
        
        return false;

    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited, int start  ){
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[] {start , -1});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int node = cell[0];
            int parent = cell[1];

            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(new int[]{neigh , node});
                }else if(neigh != parent) {
                    return true;
                }
            }
        }

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

        boolean hasCycle = isCycle(adj , V);
        System.out.println("Cycle exists: " + hasCycle);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected
    }

    
}
