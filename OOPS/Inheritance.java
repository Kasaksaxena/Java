public class Inheritance {
    public static void main(String[] args) {

        Box plainBox = new Box(10, 10, 10);
        System.out.println("--- Plain Box ---");
        plainBox.displayInfo();

        BoxWeight weightedBox = new BoxWeight(15, 20, 10, 5.5);
        System.out.println("\n--- Weighted Box ---");
        weightedBox.displayInfo();

        System.out.println("\nAccessing parent variable (length) from child: " + weightedBox.l);
    }
}

// Parent Class
class Box {
    double l, h, w;

    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    void displayInfo() {
        System.out.println("Length: " + l);
        System.out.println("Height: " + h);
        System.out.println("Width: " + w);
    }
}

// Child Class
class BoxWeight extends Box {
    double weight;

    BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Weight: " + weight + " kg");
    }
}
