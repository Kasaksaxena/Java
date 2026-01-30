public class ObjectClass{

    int num;

    public ObjectClass(int num) {
        this.num = num;
    }

    // toString override
    @Override
    public String toString() {
        return "ObjectDemo with number: " + num;
    }

    // equals override
    @Override
    public boolean equals(Object obj) {
        ObjectClass other = (ObjectClass) obj;
        return this.num == other.num;
    }

    // hashCode override
    @Override
    public int hashCode() {
        return Integer.hashCode(num);
    }

    public static void main(String[] args) {

        ObjectClass obj1 = new ObjectClass(34);
        ObjectClass obj2 = new ObjectClass(34);

        System.out.println(obj1); // toString()

        if (obj1.equals(obj2)) {
            System.out.println("They are equal!");
        }

        System.out.println(obj1.hashCode());
        System.out.println(obj1.getClass().getName());
    }
}
