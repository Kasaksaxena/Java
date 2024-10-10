import java.util.Scanner;

public class Sum{
    public static void main(String[] args){
        int ans=sum();
        System.out.println(ans);
    }

    static int sum(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter first Number");
        int num1=in.nextInt();
        System.out.println("Enter second Number");
        int num2=in.nextInt();
        int sum=num1 +num2;
        return sum;
    }

}