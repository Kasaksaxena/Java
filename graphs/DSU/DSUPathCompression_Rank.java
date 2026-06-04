import java.util.*;

class DSUPathCompression_Rank{
    static int[] parent;
    static int[] rank;

    // dsu initialization

    static void dsu(int n){
        parent = new int[n +1];
        rank = new int[n + 1];

        // inirialize evry node to be its own parent

        for(int i =0 ; i <= n ; i++){
            parent[i] =i;
            rank[i] =0;
        }


    }

    // find operation with path compression 
    static int find(int x){

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // union operation with rank

    static void union(int a , int b){

        int parenta = find(a);
        int parentb = find(b);

        if(parenta == parentb){
            return;
        }

        if(rank[parenta] > rank[parentb]){
            parent[parentb] = parenta;
        }else if(rank[parentb] > rank[parenta]){
            parent[parenta] = parentb;
        }else{
            // same rank 
            parent[parentb] = parenta;
            rank[parenta]++;
        }
    }

    public static void main(String [] args){
        dsu(5);

        union(1,2);
        union(2,3);
        union(4,5);

        System.out.println(find(3)); // 1
        System.out.println(find(5)); // 4

        if (find(1) == find(3)) {
            System.out.println("1 and 3 are Connected");
        }

        if (find(1) != find(5)) {
            System.out.println("1 and 5 are  NOT Connected");
        }

        

        


        
    }


    

}