public class PolymorphismStatic {
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
        
        System.out.println(calc.add(10, 20));       // calls add(int, int)
        System.out.println(calc.add(10, 20, 30));   // calls add(int, int, int)
        System.out.println(calc.add(5.5, 4.5));     // calls add(double, double)

        
    }

    static class Calculator{

            // Method with 2 int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with 3 int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with double parameters
    double add(double a, double b) {
        return a + b;
    }


    }



    
}
