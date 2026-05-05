import java.util.*;

public class CycleDetectionDFSPrac {

    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj ,int V){
        boolean[] visited = new boolean[V];

        for(int i =0; i <V;i++){
            if(!visited[i]){
                if (dfs( adj , i , -1, visited) ) return true;
            }
        }
        return false;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj ,int node,int parent , boolean[] visited ){
        visited[node] = true;

        for(int neigh  : adj.get(node)){
            if(!visited[neigh]){
               if( dfs(adj, neigh , node , visited)) return true;

            }
            else if( neigh != parent) return true;
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
    

