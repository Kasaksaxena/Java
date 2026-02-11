interface Operation {
    int apply(int a, int b);
}
 enum MathOperation implements Operation {

    ADD {
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MULTIPLY {
        public int apply(int a, int b) {
            return a * b;
        }
    };
}
public class EnumInterfaceDemo {
    public static void main(String[] args) {

        System.out.println(MathOperation.ADD.apply(2, 3)); // 5
        System.out.println(MathOperation.MULTIPLY.apply(2, 3)); // 6
    }
}
