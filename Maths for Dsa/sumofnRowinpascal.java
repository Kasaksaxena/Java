/* pascal formula is 2 power(n-1)
and 1<<2(n-1) gives 1*2pow(n-1)*/

public class sumofnRowinpascal{
    public static void main(String[] args) {
        int n =8;
        int ans=1<<(n-1);

        System.out.println(ans);
        
    }
}