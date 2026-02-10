public class Main {

    public static void main(String[] args) {

        // Integer list
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30); // resize happens here

        System.out.println(numbers.get(0)); // 10
        System.out.println(numbers.get(1)); // 20
        System.out.println(numbers.get(2)); // 30
        System.out.println("Size: " + numbers.size());

        // String list
        MyArrayList<String> names = new MyArrayList<>();
        names.add("Kasak");
        names.add("AI");
        names.add("Java");

        System.out.println(names.get(0)); // Kasak
        System.out.println(names.get(1)); // AI
        System.out.println(names.get(2)); // Java
        System.out.println("Size: " + names.size());
    }
}
