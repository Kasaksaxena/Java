import java.util.*;

public class DFSExample2 {

    static void dfs(int node , boolean[] visited , List<List<Integer>> adj ){
        visited[node] = true;
        System.out.print(node + " ");


        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, visited , adj);
            }
        }
    }

    public static void main (String[] args){
        int V= 7;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[7];
        for(int i =0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(6);
        adj.get(6).add(0);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(4);
        adj.get(2).add(3);
        adj.get(4).add(2);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(5).add(3);

        System.out.println("DFS traversal: ");
        dfs(1,visited,adj);





    }


    
}
