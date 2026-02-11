import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {

        Collection<String> names = new ArrayList<>();

        names.add("Kasak");
        names.add("Java");
        names.add("Collections");

        System.out.println(names.size());      // 3
        System.out.println(names.contains("Java")); // true

        names.remove("Java");
        System.out.println(names); // [Kasak, Collections]
    }
}
