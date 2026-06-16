import java.util.*;
import java.util.Arrays;
public class DijkstrasAlgo {

    static class Pair{
        int node;
        int cost;
        Pair(int  node , int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    static int[] dijkstra(ArrayList<ArrayList<Pair>> graph , int src){
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.node ;
            int currcost = current.cost;
            for(Pair neigh : graph.get(node)){
                int neighnode =  neigh.node;
                int weight = neigh.cost;
                if(currcost + weight < dist[neighnode] ){
                    dist[neighnode] = currcost + weight;
                    pq.add(new Pair(neighnode , dist[neighnode]));
                }

            }

        }
    return dist ;

    }
    public static void main(String[] args){
        int V = 5;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 1);
        addEdge(graph, 2, 1, 2);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 2, 3, 5);
        addEdge(graph, 3, 4, 3);

        System.out.println("Graph Structure:");
        printGraph(graph);

        int[] dist = dijkstra(graph, 0);

        System.out.println("\nShortest Distances:");

        for (int i = 0; i < V; i++) {
            System.out.println("0 -> " + i + " = " + dist[i]);
        }
    }

    static void addEdge(ArrayList<ArrayList<Pair>> graph,
                        int u,
                        int v,
                        int weight) {

        graph.get(u).add(new Pair(v, weight));
        graph.get(v).add(new Pair(u, weight));
    }

    static void printGraph(ArrayList<ArrayList<Pair>> graph) {

        for (int i = 0; i < graph.size(); i++) {

            System.out.print(i + " -> ");

            for (Pair neighbour : graph.get(i)) {

                System.out.print(
                        "(" + neighbour.node +
                        "," + neighbour.cost + ") ");
            }

            System.out.println();
        }
    }
}
