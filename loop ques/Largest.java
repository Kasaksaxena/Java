import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int a = input.nextInt();
        int b= input.nextInt();
        int c= input.nextInt();

        /*if(a>b && a>c){
            System.out.println("Max is a:" + a);
        }
        else if(b>a && b>c){
            System.out.println("Max is b:" + b);

        }
        else {
            System.out.println("Max is c:" + c);
        }
        */

       int max=Math.max(c,Math.max(a,b));
       System.out.println("Max is :" + max);
    }

}