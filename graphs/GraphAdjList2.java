import java.util.*;

public class GraphAdjList2 {
    public static void main(String[] args){
        int V = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i< V ; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph , 0 , 1);
        addEdge(graph , 0 , 4);
        addEdge(graph , 1 , 2);
        addEdge(graph , 4 , 3);

        printGraph(graph);

    }

    static void  addEdge(ArrayList<ArrayList<Integer>> graph, int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph){
        // outer loop
        for(int i =0 ; i < graph.size(); i++){
            System.out.print(i +  "->" );

            for( int neigbour : graph.get(i)){
                System.out.print(neigbour + " ");
            }
            System.out.println( );


        }
    }




    
}
