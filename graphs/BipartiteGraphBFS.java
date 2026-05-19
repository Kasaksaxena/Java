import java.util.*;

public class BipartiteGraphBFS {

    static boolean isbipartite(ArrayList<ArrayList<Integer>> graph , int V ){

        int[] colorpalatte = new int[V];
        // red = 1  , blue = -1
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(colorpalatte[i] == 0){
                q.offer(i);
                colorpalatte[i] = 1;
            }

            while(!q.isEmpty()){
                int node =  q.poll();

                for(int neigh : graph.get(node)){
                    if(colorpalatte[neigh] == 0){
                        colorpalatte[neigh] = -colorpalatte[node] ;
                        q.offer(neigh);
                    }else if(colorpalatte[neigh] == colorpalatte[node]){
                        return false;
                    }
            }
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
