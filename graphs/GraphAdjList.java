import java.util.*;

public class GraphAdjList {
    public static void main (String[] args){
        int V = 4;// no of vertices
        
        // create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initialize empty lists for each node
        for(int i =0; i< V; i++){
            graph.add(new ArrayList<>());
        }
        // add edges undirected

        addEdge(graph, 0 , 1);
        addEdge(graph, 0 , 2);
        addEdge(graph, 1 , 3);
        addEdge(graph, 2 , 3);

        // print graph
        printGraph(graph);

    }
    // add edge undirected
    static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);


    }

    // print adjacency list
    static void printGraph(ArrayList<ArrayList<Integer>> graph){
        for(int i = 0; i< graph.size(); i++){
            System.out.print(i + "->");
            for(int neighbour : graph.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

    
}
