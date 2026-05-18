import java.util.*;

public class BipartiteGraphDFS{

    static boolean isbipartite(ArrayList<ArrayList<Integer>> graph , int V ){

        int[] colorpallete = new int[V];
        // re = 1   blue = -1
        int color =1;
        for(int i = 0; i <V; i++){
            if (colorpallete[i] == 0){
                if(!dfs( i ,color, colorpallete , graph)) return false;;
            }

            
        }
    return true;
    }
    static boolean dfs(int node ,int color , int[] colorpallete, ArrayList<ArrayList<Integer>> adj){

        colorpallete[node] = color;
        for(int neigh : adj.get(node) ){
            if(colorpallete[neigh] == 0){
               if( !dfs(neigh , -color , colorpallete , adj)){
                return false;
               };
            }
            else if(colorpallete[neigh] == color){
                return false;
            }

        }
    return true;

        }

            public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(3);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(0);
        graph.get(3).add(2);

        System.out.println(isbipartite(graph, V));
    }


    

}