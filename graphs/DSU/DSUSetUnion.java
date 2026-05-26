import java.util.*;

class DSUSetUnion{
    static int[] parent;
    static void  dsu(int n){
        parent = new int[n + 1];
        // initially every node is it own  parent
        for(int i =0; i <n;i++){
            parent[i] =i;
        }
    }
    // find operation
    // find ultimate parent
    static int find(int x){
        // if node is it own parent return node
        if(parent[x] == x){
            return x;
        }

        return find(parent[x]);
    }

      // union operation 
      // connect two sets  
    static void union(int a , int b){
        // find parents
        int parentA = find(a);
        int parentB = find(b);

        // check if parent same if not connect them
        if(parentA != parentB){
         
            parent[parentB] = parentA;
        }

    }

    public static void main(String[] args){
        dsu(5);

        union(1,2);
        union(2,3);

        System.out.println(find(3));

        // check connections
        if( find(1) == find(3)){
            System.out.println("Connected");

        }else{
             System.out.println(" NOT Connected");

        }
        }

    
 
    }
