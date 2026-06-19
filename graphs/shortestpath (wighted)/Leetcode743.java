import java.util.*;
public class Leetcode743 {

    static class Pair{
        int node;
        int cost;
        Pair(int node , int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i =0 ; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        // build graph 
        for(int[]  edge : times ){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair (v ,w));

        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a,b) -> a.cost - b.cost);
        
        pq.add( new Pair (k,0));
        while(!pq.isEmpty()){
           Pair current = pq.poll();
           int currnode = current.node;
           int currcost = current.cost;

           for(Pair neigh : graph.get(currnode)){
            int neighnode = neigh.node;
            int neighcost = neigh.cost;

            if(currcost + neighcost <dist[neighnode]){
                dist[neighnode] = currcost + neighcost;

                pq.add(new Pair ( neighnode , dist[neighnode]));
            }
           }
            
        }

        int ans = Integer.MIN_VALUE;
        for(int i =1 ; i <=n ;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans , dist[i]);


        }


    return ans ;
        
    }
        public static void main(String[] args) {

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        int answer = networkDelayTime(times, n, k);

        System.out.println(answer);
    }

    
}
