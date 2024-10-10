import java.util.Scanner;

public class Reverse{
    public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      int n= in.nextInt();
      int num=0;
      while(n>0){
        int rem=n%10;
        num=rem+ 10*num;

        n=n/10;
      }
    System.out.println(num);
    }

}    
