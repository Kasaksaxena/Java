import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      int a=0;

      int b=1;
      int sum=0;
      int n= in.nextInt();

      for(int i=2;i<=n;i++){
        sum=a+b;

        System.out.println(a);
        a=b;
        b=sum;
        
        


      }
    System.out.println("sum is" +sum);

    }
}