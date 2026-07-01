import java.util.*;
public class PrimsAlgorithm {

    static class Pair{
        int node;
        int cost;
        Pair(int node , int cost){
            this.node =node;
            this.cost = cost;
        }
    }

        static int primMST(ArrayList<ArrayList<Pair>> graph) {
            int n = graph.size();

            boolean[] visited = new boolean[n];

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.cost -b.cost
            );

            pq.offer(new Pair(0,0));

            int totalcost =0;

            while(!pq.isEmpty()){
                Pair current = pq.poll();

                int node = current.node;
                int cost = current.cost;

                if(visited[node]){
                    continue;
                }

                visited[node] = true;
                totalcost += cost;

                for(Pair neigh : graph.get(node)){
                     if(!visited[neigh.node]){
                        pq.offer(new Pair (neigh.node , neigh.cost));

                     }
                }
            }
        return totalcost;
        }

        static void addEdge(
            ArrayList<ArrayList<Pair>> graph,
            int u,
            int v,
            int w) {

        graph.get(u).add(new Pair(v, w));
        graph.get(v).add(new Pair(u, w));
    }

    static void printGraph(
            ArrayList<ArrayList<Pair>> graph) {

        for (int i = 0; i < graph.size(); i++) {

            System.out.print(i + " -> ");

            for (Pair neighbour : graph.get(i)) {

                System.out.print("("
                        + neighbour.node
                        + ", "
                        + neighbour.cost
                        + ") ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        System.out.println("Graph:");

        printGraph(graph);

        int answer = primMST(graph);

        System.out.println("\nMinimum Cost = " + answer);
    }

    
}
