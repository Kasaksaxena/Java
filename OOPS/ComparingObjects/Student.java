public class Student implements Comparable<Student> {

    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // comparison logic
    @Override
    public int compareTo(Student other) {

        // compare based on marks
        if (this.marks == other.marks) {
            return 0;
        } else if (this.marks > other.marks) {
            return 1;
        } else {
            return -1;
        }
    }
}
