import java.util.*;

public class DFSIterativeExample2{

    static void dfs(int node , boolean[] visited, List<List<Integer>> adj ){


        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){

            int n = stack.pop();
            if(!visited[n]){
            visited[n] = true;
            System.out.print(n + " ");
            }

            List<Integer> neighbours = adj.get(n);
            for( int i = neighbours.size()- 1; i >=0 ; i-- ){
                int neighbour = neighbours.get(i);
                if(!visited[neighbour]){
                    stack.push(neighbour);
                }
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