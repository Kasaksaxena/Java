public class Odd_even{
    public static void main(String[] args){
        int n=67;
        System.out.println(Odd(n));
    }
    static boolean Odd(int n){
        return(n & 1)==1;
        
    }
}