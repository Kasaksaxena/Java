public class powof2ornot{
    public static void main(String[] args) {
        int n=18;
        boolean ans=(n & (n-1))==0;
        System.out.print(ans);
    }
}