

public class Factors{
    public static void main(String[] args) {
        factors2(20);
    }
    //time complexity O(n)
    static void factors1(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i + "");
            }
        }
    }

    // Time complex=O(rootn)
// optimized approach loops only upto root n,reducing no of iterations
    static void factors2(int n){
        for(int i=1;i<= Math.sqrt(n);i++){
            if(n%i==0){
               if(n/i==i){
                 System.out.println(i);
               } 
               System.out.println(i + " " + n/i);

            }
        }
    }
}