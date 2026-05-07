import java.util.*;

public class ToplogicalOrderDFS{

    static ArrayList<Integer> sort(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i <V ; i++){
            if(!visited[i]){
                dfs(adj , visited,stack ,i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());

        }
        return result;

    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited , Stack<Integer> stack,int node){
        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
            dfs(adj,visited ,stack , neigh);
            }
        }
        stack.push(node);


        
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;

        for(int i = 0; i < V ; i++){
            adj.add( new ArrayList<>());
        }

        adj.get(0).add(3);
        adj.get(0).add(2);

        adj.get(1).add(4);

        adj.get(2).add(3);
        adj.get(2).add(1);

        adj.get(3).add(1);

        adj.get(5).add(1);
        adj.get(5).add(4);

        ArrayList<Integer> result = sort(adj,V);
        System.out.println(result);

    }

}