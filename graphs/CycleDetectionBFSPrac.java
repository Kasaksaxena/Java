import java.util.*;
import java.util.LinkedList;

public class CycleDetectionBFSPrac {

    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];

        for(int i = 0 ; i < V; i++){
            if(!visited[i]){
                if(bfs(adj , visited ,i)) return true;
            }
        }
        return false;
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited , int start){

            Queue<int[] > q = new LinkedList<>();
            q.add(new int[] {start , -1});

            while(!q.isEmpty()){
                int[] cell = q.poll();
                int node = cell[0];
                int parent = cell[1];

                for(int neigh : adj.get(node)){
                    if(!visited[neigh]){
                        visited[neigh] = true;
                        q.add(new int[] { neigh , node});
                    }else if(neigh != parent){
                        return true;
                    }
                }

            }
            return false;
    }

    public static void main(String[] args){
        int V = 7 ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for(int i = 0; i < V ; i++){
            adj.add( new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(1);
        adj.get(5).add(6);

        boolean hasCycle = hasCycle(adj, V);
        System.out.println("Cycle exists: " + hasCycle);
    }



        

    
}
