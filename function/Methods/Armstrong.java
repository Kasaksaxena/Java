import java.util.Scanner;

public class Armstrong{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        //System.out.println("Enter the number:");

        // checking given no is armstrong or not
        //int n= in.nextInt();
        //boolean Ans=isArmstrong(n);
        //System.out.println(Ans);
        
        //printing 3 digit all armstrong no
        for(int i=100;i<1000;i++){
            if(isArmstrong(i)){
                System.out.println(i);
            }
        }

    }
    static boolean isArmstrong(int n){
        int num=n;
        int sum=0;

        while(n>0){
            int rem= n%10;
            sum=sum+rem*rem*rem;
            n=n/10;

        }
        return sum==num;
        }


    }
