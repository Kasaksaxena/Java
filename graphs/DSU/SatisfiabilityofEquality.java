import java.util.*;

public class SatisfiabilityofEquality {
    static int[] parent;
    
    static void dsu(){
        int n =26;
        parent = new int[n + 1];

        for(int i =0;i<= n;i++){
            parent[i] = i;
        }
    }

    static int find(int x){

        if(parent[x] == x){
            return x;
        }

        return  parent[x]= find(parent[x]);
    }

    static void union(int a ,int b){

        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB){
            parent[parentB] = parentA;
                
        }
    }



    public static boolean result(String[] eqs){
        dsu();
                // Pass 1: Process all ==
        for(String eq : eqs){
            if(eq.charAt(1) == '='){
              int a = eq.charAt(0) - 'a';
              int b = eq.charAt(3) - 'a';
              union(a,b);

            }
        }

        for(String eq : eqs){
            if(eq.charAt(1) == '!'){
              int a = eq.charAt(0) - 'a';
              int b = eq.charAt(3) - 'a';
              if(find(a) == find(b)){
                return false;
              }

            }


        }
        
     return true;
    }
    public static void main (String[] args){
        String[] equations = {
            "a==b",
            "b==c",
            "a!=c"
        };
        boolean ans = result(equations);

        System.out.println(ans);
    }




    }
    

