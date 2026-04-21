 import java.util.*;
 import java.util.LinkedList;
public class BFSExample {

    static void Bfstraversal(ArrayList<ArrayList<Integer>> graph , int start){
        boolean[] visited  = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " " );
            for( int neighbour : graph.get(node)){
                if (visited[neighbour] == false){
                    visited[neighbour] = true;
                    q.add(neighbour);

                }
            }

        }

    }
   
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i= 0; i< V; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph , 0,1);
        addEdge(graph , 0,2);
        addEdge(graph , 1,3);
        addEdge(graph , 2,3);



        System.out.println("Graph structure :" );
        printGraph(graph);

        System.out.println("BfsTraversal :" );


        Bfstraversal(graph, 0);



        
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
