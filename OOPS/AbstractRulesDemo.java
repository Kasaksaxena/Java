// RULE 1: Abstract class declared using 'abstract'
abstract class Animal {

    // RULE 2: Abstract method (no body)
    abstract void sound();

    // RULE 3: Concrete (non-abstract) method allowed
    void sleep() {
        System.out.println("Animal is sleeping");
    }

    // RULE 4: Abstract class can have instance variables
    int age;

    // RULE 5: Abstract class can have constructor
    Animal(int age) {
        this.age = age;
        System.out.println("Animal constructor called");
    }

    // RULE 6: Abstract class can have static method
    static void info() {
        System.out.println("Animals are living beings");
    }

    // RULE 7: Abstract class can have final method
    final void breathe() {
        System.out.println("Animal is breathing");
    }
}

// RULE 8: Child class must extend abstract class
class Dog extends Animal {

    // RULE 9: Child MUST implement all abstract methods
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    Dog(int age) {
        super(age); // Calls abstract class constructor
    }
}

// RULE 10: Another child class
class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }

    Cat(int age) {
        super(age);
    }
}

// RULE 11: Main class
public class AbstractRulesDemo {

    public static void main(String[] args) {

        // RULE 12: Cannot create object of abstract class
        // Animal a = new Animal(5); ❌ ERROR

        // RULE 13: Reference of abstract class allowed
        Animal dog = new Dog(3);
        Animal cat = new Cat(2);

        dog.sound();   // Dynamic binding
        dog.sleep();   // Inherited concrete method
        dog.breathe(); // Final method

        cat.sound();
        cat.sleep();

        // RULE 14: Static method called using class name
        Animal.info();

        // RULE 15: Accessing variable from abstract class
        System.out.println("Dog age: " + dog.age);
    }
}
