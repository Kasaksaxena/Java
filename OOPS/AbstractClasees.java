
abstract class Vehicle {

    // Abstract method (no body)
    abstract void start();

    // Concrete method
    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    // Must implement abstract method
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with self button");
    }
}

public class AbstractClasees {

    public static void main(String[] args) {

        // Vehicle v = new Vehicle(); ❌ NOT allowed

        Vehicle car = new Car();   // Polymorphism
        Vehicle bike = new Bike();

        car.start();
        car.stop();

        bike.start();
        bike.stop();
    }
}

