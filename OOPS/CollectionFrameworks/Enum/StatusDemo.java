 enum Status {

    SUCCESS(200),
    ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
public class StatusDemo {
    public static void main(String[] args) {

        System.out.println(Status.SUCCESS.getCode()); // 200
    }
}

