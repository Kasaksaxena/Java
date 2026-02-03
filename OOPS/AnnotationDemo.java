import java.lang.annotation.*;

// RULE 1: Define annotation
@Retention(RetentionPolicy.RUNTIME) // available at runtime
@Target(ElementType.METHOD)          // can be used on methods
@interface MyAnnotation {
    String value();
}

// Using annotation
class Demo {

    @MyAnnotation(value = "Important Method")
    void test() {
        System.out.println("Test method");
    }
}

public class AnnotationDemo {

    public static void main(String[] args) throws Exception {

        Demo d = new Demo();

        // Access annotation using reflection
        java.lang.reflect.Method method =
                d.getClass().getMethod("test");

        MyAnnotation ann = method.getAnnotation(MyAnnotation.class);

        System.out.println("Annotation value: " + ann.value());
    }
}
 
