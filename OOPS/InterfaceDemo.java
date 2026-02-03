// RULE 1: Interface declaration
interface Flyable {

    // RULE 2: Variables are public static final by default
    int MAX_HEIGHT = 1000;

    // RULE 3: Methods are public abstract by default
    void fly();
}

// RULE 4: Another interface
interface Swimmable {
    void swim();
}

// RULE 5: Class implements multiple interfaces
class Duck implements Flyable, Swimmable {

    // RULE 6: Must implement all methods
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}

// RULE 7: Interface reference allowed
public class InterfaceDemo {

    public static void main(String[] args) {

        Flyable f = new Duck(); // Polymorphism
        f.fly();

        Swimmable s = new Duck();
        s.swim();

        // RULE 8: Access constant
        System.out.println("Max height: " + Flyable.MAX_HEIGHT);

        // Flyable obj = new Flyable(); ❌ NOT allowed
    }
}

