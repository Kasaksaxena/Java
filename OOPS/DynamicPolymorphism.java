public class DynamicPolymorphism {
    public static void main(String[] args) {

        Shape s1 = new Circle();      // parent reference, child object
        Shape s2 = new Rectangle();

        s1.draw();   // Circle's draw()
        s2.draw();   // Rectangle's draw()
    }



 static class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

static class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

static class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

}

