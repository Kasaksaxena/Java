import java.util.*;

public class DSUCYCLEDETECTION {
    static int[] parent;

    static void dsu(int n){
        parent = new int[n + 1];

        for(int i =0; i <= n; i++){
            parent[i] = i;
        }

    }

    static int find(int x){

      if(parent[x] == x){
        return x;
      }

      return find(parent[x]);
    }


    static void union(int a , int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB){
            parent[parentB] = parentA;

        }
    }

    public static void main(String[] args){
        int n = 3;

        // Graph edges
        int[][] edges = {
            {1, 2},
            {2, 3},
            {1, 3}
        };

        dsu(n);

        boolean cylcepresent = false;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            //If both nodes already belong
            // to the same group => Cycle
            if(find(u) == find(v)){
                cylcepresent = true;
                System.out.println(
                    "Cycle Found at edge: (" + u + "," + v + ")"
                );
                break;

            }

            // Otherwise connect them
            union(u,v);


        }
        if(!cylcepresent){
            System.out.println("No Cycle");

        }

    }
    
}
