import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Kasak", 90));
        students.add(new Student("Aman", 85));
        students.add(new Student("Riya", 95));

        Collections.sort(students);

        for (Student s : students) {
            System.out.println(s.name + " " + s.marks);
        }
    }
}
