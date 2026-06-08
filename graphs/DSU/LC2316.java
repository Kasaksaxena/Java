import java.util.HashMap;

public class LC2316 {
    static int[] parent;

    public static long countPairs(int n, int[][] edges) {

        dsu(n) ;
        for( int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            union(a,b);
        }

        // build componenets 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<n;i++){
            int leader = find(i);

            map.put(leader , map.getOrDefault(leader, 0) + 1);

        }
        long result =0;

        long remaining = n;
        for(int size : map.values()){
            remaining -= size;
            result += (long)size * (remaining);
        }


     return result;
    }

    static void dsu(int n){
        parent = new int[n +1];

        for(int i =0; i <= n;i++){
            parent[i] =i;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a ,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB){
            parent[parentB] = parentA;
        }
    }

    public static void main (String[] args){
        int n =7;
        int[][] edges ={
            {0,2},{0,5},{2,4},{1,6},{5,4}
        };
        long result = countPairs(n , edges);
        System.out.println(result);
    }


    
}
