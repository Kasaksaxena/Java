// Enhanced switch(alt +click)
import java.util.Scanner;

public class Switch{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        /*int day=input.nextInt();
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wedday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Satday");
            case 7 -> System.out.println("Sunday");
            default ->System.out.println("Enter valid number");
        }*/
       
        int day=input.nextInt();
        switch(day){
            

        case 1:
        case 2:
        case 3:
        case 4:    
        case 5:
            System.out.println("weekdays");
            break;
        case 6:    
        case 7:
            System.out.println("weekend");
            break;
        default :
         System.out.println("Enter valid number");  
            
        
        }
    }
}