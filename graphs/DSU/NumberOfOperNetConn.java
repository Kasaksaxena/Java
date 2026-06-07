
public class NumberOfOperNetConn {
    static int[] parent;

    static void dsu(int n){
        parent = new int[n+1];

        for(int i =0;i <= n; i++){
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

    public static int makeconnected(int n , int[][] connections){
        dsu(n);
        int extracables = 0;

        for(int[] edge : connections){
            int a = edge[0];
            int b = edge[1];
            if(find(a) == find(b)){
                extracables++;
            }else{
                union(a,b);
            }

        }

        int components =0;
        for(int i =0; i < n;i++){
            if(find(i)== i){
                components++;
            }
        }

        int requiredcables = components -1;
        
        if(requiredcables<=extracables){
            return requiredcables;

        }else{
            return -1;
        }
    }

    public static void main(String[] args) {

        int n =4;
        int[][] connections = {
            {0,1},{0,2},{1,2}
        };
        int ans = makeconnected(n,connections);
        System.out.println(ans);
    }
}
