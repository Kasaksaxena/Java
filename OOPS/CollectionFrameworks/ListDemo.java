import java.util.*;

public class ListDemo {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // duplicates allowed

        System.out.println(numbers); // [10, 20, 10]
        System.out.println(numbers.get(1)); // 20

        List<String> cities = new LinkedList<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Pune");
        System.out.println(cities); 


        cities.remove(1); // fast deletion
        System.out.println(cities); 


    }
}
