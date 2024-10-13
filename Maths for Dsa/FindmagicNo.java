/*The code essentially converts the binary digit of n=6
into a number based on power of 5. for 6 which is 110
in binary the result is 150 */

public class FindmagicNo{
    public static void main(String[] args) {
        int n=6;
        int ans=0;
        int base=5;

        while(n>0){
            int last=n&1;
            n=n>>1;
            ans+=last*base;
            base=base*5;
            
        }
        System.out.println(ans);
    }
}