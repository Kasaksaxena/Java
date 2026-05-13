import java.util.*;
public class eventualSafeNodes {
         List<Integer> eventualSafeNodes(int[][] graph) {

//      Build reverse graph
            int V = graph.length;
            int[] outdegree = new int[V];
            ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
            for (int i = 0; i < V; i++){
              revadj.add(new ArrayList<>());
            }

            for(int i = 0; i < V ; i++){
                outdegree[i] = graph[i].length;
                for(int neigh : graph[i]){
                    revadj.get(neigh).add(i);
                }
            }

            Queue<Integer> q = new LinkedList<>();

            for(int i =0; i < V; i++){
                if(outdegree[i]== 0){
                    q.offer(i);
                    
                }
            }

            List<Integer> ans = new ArrayList<>();

            while(!q.isEmpty()){
                int node = q.poll();
                ans.add(node);

                for(int neigh : revadj.get(node)){
                    outdegree[neigh]--;
                    if(outdegree[neigh] == 0){
                        q.offer(neigh);
                    }
                }


            }
            Collections.sort(ans);
            
            return ans ;
        
    }
    
    public static void main(String[] args) {

        eventualSafeNodes obj = new eventualSafeNodes();

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> result = obj.eventualSafeNodes(graph);

        System.out.println("Safe Nodes: " + result);
    }

    
}
