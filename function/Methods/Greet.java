import java.util.Scanner;

public class Greet{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your name:");
        String Name= in.next();
        String wish=greet(Name);
        System.out.println(wish);
    }

    static String greet(String Name){
        
        String greeting="Hello\n" + Name +"\n"+ "How are you?";
        return greeting;
        
    }
}