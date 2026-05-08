import java.util.*;

public class ToplogicalOrderDFSPrac {

    static ArrayList<Integer> sort(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V ; i ++){
            if(!visited[i]){
                dfs(adj , visited, stack ,i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());

        }
        return result;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited , Stack<Integer> stack , int node){
        visited[node] = true;

        for(int neigh  : adj.get(node)){
            if(!visited[neigh]){
                dfs(adj,visited, stack , neigh);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args){
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0 ; i < V; i++){
            adj.add(new ArrayList<>());

        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(5);
        adj.get(4).add(5);
        adj.get(5).add(6);

        ArrayList<Integer> result = sort(adj, V);
        System.out.println(result);






    }
    
}
