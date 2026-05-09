import java.util.*;
import java.util.LinkedList;

public class KanhAlgo {

    static void kahn(ArrayList<ArrayList<Integer>> adj, int V ){
        int[] indegree = new int[V];

        //calc indegree
        for(int i =0; i < V;i++){
            for(int neigh : adj.get(i)){
                indegree[i]++;
            }
        }

        // create queue
        Queue<Integer> q = new LinkedList<>();

        // add all indegree 0 to queue
        for(int i = 0; i <V ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // topo stote
        ArrayList<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node =  q.poll();
            topo.add(node);
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }

        }

        System.out.println("Topological Sort:");

        for (int node : topo) {
            System.out.print(node + " ");
        }

    }
        public static void main(String[] args) {

        int V = 4;

        // Adjacency List
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);

        kahn(graph, V);
    }


    
}
