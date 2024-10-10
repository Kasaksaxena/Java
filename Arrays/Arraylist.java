import java.util.Scanner;
import java.util.ArrayList;

public class Arraylist{
    public static void main(String[] args){

      ArrayList<Integer> list = new ArrayList<>(10);
      Scanner in= new Scanner(System.in);
      /*list.add(45);
      list.add(35);
      list.add(25);
      list.add(75);
      list.add(95);
      list.add(85);
      list.add(15);  


      System.out.println(list);
      System.out.println(list.contains(45));
      System.out.println(list.set(2,955));
      System.out.println(list);
       */

      // input

      for(int i=0;i<5;i++){
        list.add(in.nextInt());
      }

      // get any item at index
      for(int i=0;i<5;i++){
        System.out.println(list.get(i));
      }
       System.out.println(list);
    }
}