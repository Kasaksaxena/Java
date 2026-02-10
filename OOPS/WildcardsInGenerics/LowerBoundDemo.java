import java.util.*;

public class LowerBoundDemo {

    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addNumbers(numbers);
        addNumbers(objects);

        System.out.println(numbers);
        System.out.println(objects);
    }
}
