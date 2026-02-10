public class Main {
    public static void main(String[] args) {

        try {
            int a = 10 / 0;
            System.out.println(a);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program continues...");
    

        try {
           int[] arr = new int[3];
          arr[5] = 10;
    }   catch (ArithmeticException e) {
        System.out.println("Arithmetic error");
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Index error");
    }

}
}

