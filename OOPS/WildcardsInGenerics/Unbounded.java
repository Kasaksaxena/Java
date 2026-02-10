
import java.util.*;

public class Unbounded {

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);
        List<String> names = List.of("Kasak", "AI");

        printList(nums);
        printList(names);
    }
}

