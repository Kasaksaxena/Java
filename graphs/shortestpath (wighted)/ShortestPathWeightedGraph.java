import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
public class ShortestPathWeightedGraph {

    static class Pair{
        int node;
        int cost;
        Pair(int node , int cost){
            this.node= node;
            this.cost = cost;
        }
    }

    static List<Integer> shortestPath(int n,
                                      ArrayList<ArrayList<Pair>> graph) {

        int[] parent = new int[n+1];
        int[] dist = new int[n+1];

        Arrays.fill(dist , Integer.MAX_VALUE);

        for(int i = 0; i <= n ; i ++){
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost
        );

        dist[1] = 0;

        pq.add(new Pair(1, 0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();

            int currnode = current.node;
            int currcost = current.cost;

            for(Pair neigh : graph.get(currnode)){
                int neighnode = neigh.node;
                int neighcost = neigh.cost;

                if(currcost + neighcost < dist[neighnode]){
                    dist[neighnode]= currcost + neighcost;

                    parent[neighnode] = currnode;

                    pq.add( new Pair ( neighnode , dist[neighnode]) );
                }

            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        return path;
}

static void addEdge(
    ArrayList<ArrayList<Pair>> graph , int u , int v , int w
){
    graph.get(u).add(new Pair(v,w));
    graph.get(v).add(new Pair(u,w));

}

public static void main(String[] args){
    int n =5;
    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

    for(int i =0; i <= n ;i++){
        graph.add(new ArrayList<>());
    }

    addEdge(graph ,1,2,2);
    addEdge(graph ,1,3,4);
    addEdge(graph ,2,3,1);
    addEdge(graph ,2,4,7);
    addEdge(graph ,3,5,3);
    addEdge(graph ,4,5,1);
    
    List<Integer> path = shortestPath(n , graph);
    System.out.println(path);

}



    
}
