import java.util.*;

public class DetectCycleDirectedBFS {

    static boolean cycle(ArrayList<ArrayList<Integer>> adj , int V){
        int[] indegree = new int[V];

        // calc indegree
        for(int i =0; i < V; i++){
            for(int neigh : adj.get(i)){
                indegree[neigh]++;
            }

        }

        Queue<Integer> q = new LinkedList<>();

        // indegree 0 to queue
        for(int i = 0; i <V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;


        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

    return count!= V;

        
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

        boolean hasCycle = cycle( adj , V);
        System.out.println("Cycle exists: " + hasCycle);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }



    }


    
