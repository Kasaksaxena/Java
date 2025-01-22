public class ReverseNo{
    public static void main(String[] args) {
       reverse1(1234);
        System.out.println(sum);
        System.out.println(reverse2(3456));

    }

    static int sum=0;

    static void reverse1(int n){

        if(n==0){
            return;
        }
       int rem=n%10;
        sum=sum * 10 +rem;
        reverse1(n/10);

    }

    static int reverse2(int n){
        //sometimes you might need some additional var in argument
        //in that case, make another func

        //formula Math.log10(n) gives logarithm base 10 of n.adding 1 and converting it to an integer gives count of digitd
        
        int digits=(int)(Math.log10(n)) + 1;
        return helper(n,digits);
    }
    private static int helper(int n,int digits){
        //base condition if no is single return no itself as it is already reversed
        if( n%10==n){
            return n;
        }
        int rem= n%10;
        return rem* (int)(Math.pow(10,digits-1)) +helper(n/10,digits-1);
    }
}