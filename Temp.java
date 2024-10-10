import java.util.Scanner;

public class Temp {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Please enter temp in C");
        float tempC=input.nextFloat();
        float tempf=(tempC + 9/5) + 32 ;

        System.out.println(tempf);
    }

}