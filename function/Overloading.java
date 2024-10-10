public class Overloading{
    public static void main(String[] args){
        func("AADHI");
        func(9875);
    }

    static void func(int a){
        System.out.println(a);
    }

    static void func(String name){
        System.out.println(name);
    }
}