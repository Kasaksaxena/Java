import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;

public class InBuiltClassesDemo {

    public static void main(String[] args) {

        // java.lang (auto imported)
        String name = "Java";
        System.out.println("Length: " + name.length());
        System.out.println("Square root: " + Math.sqrt(16));

        // java.util - ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        System.out.println("ArrayList: " + list);

        // java.util - HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        System.out.println("HashMap: " + map);

        // java.util - Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String user = sc.nextLine();
        System.out.println("Hello " + user);

        sc.close();
    }
}
