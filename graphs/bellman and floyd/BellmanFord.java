import java.util.*;
public class BellmanFord {

    static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source ,int destination , int weight){
            this.source = source;
            this.destination = destination;
            this.weight= weight;
        }
    }

        static int[] bellmanFord(ArrayList<Edge> edges, int vertices, int source) {

            int[] dist = new int[vertices];

            Arrays.fill(dist,Integer.MAX_VALUE);

            dist[source] =0;

            // relax v-1 times

            for(int i =1; i <= vertices -1; i++){
              for(Edge edge : edges){
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                 if(dist[u]!= Integer.MAX_VALUE && dist[u] + w <dist[v] ){
                    dist[v] = dist[u] + w;
                 }
              }


            }
//    negative cycle
            for(Edge edge : edges){
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                 if(dist[u]!= Integer.MAX_VALUE && dist[u] + w <dist[v] ){
                    dist[v] = dist[u] + w;
                    System.out.println("Negative cycle detected");
                    return new int[0];
                 }
              }
        return dist;
        }

        static void addEdge(ArrayList<Edge> edges , int u , int v, int w){
            edges.add( new Edge(u ,v ,w));

        }

        public static void main (String[] args){
            ArrayList<Edge> edges = new ArrayList<>();
            int vertices = 5;
                    addEdge(edges, 0, 1, 6);
        addEdge(edges, 0, 2, 7);
        addEdge(edges, 1, 2, 8);
        addEdge(edges, 1, 3, 5);
        addEdge(edges, 1, 4, -4);
        addEdge(edges, 2, 3, -3);
        addEdge(edges, 2, 4, 9);
        addEdge(edges, 3, 1, -2);
        addEdge(edges, 4, 0, 2);
        addEdge(edges, 4, 3, 7);

        int source = 0;

        int[] answer = bellmanFord(edges, vertices, source);

        if (answer.length != 0) {

            System.out.println("Shortest Distance:");

            for (int i = 0; i < answer.length; i++) {

                System.out.println(
                        "0 -> " + i + " = " + answer[i]
                );
         
                    

            }
        }
    
}
}
