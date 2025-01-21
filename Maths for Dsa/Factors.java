
import java.util.ArrayList;



public class Factors{
    public static void main(String[] args) {
        factors3(20);

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
    
// time and space complexity O(root n)
    static void factors3(int n){
        ArrayList<Integer> list=new ArrayList<>();//stores n/i values temporarely
        for(int i=1;i<= Math.sqrt(n);i++){
            if(n%i==0){
               if(n/i==i){
                 System.out.println(i);
               } 
               else{
               System.out.println(i + " ");
               list.add(n/i);
               }
            }
}
    for(int i=list.size()-1 ;i >=0;i--) {
        System.out.print(list.get(i) + " ");

    }


}
}