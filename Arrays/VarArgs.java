import java.util.Arrays;

public class VarArgs{
    public static void main(String[] args){
        fun(2,3,4,5,8,7,9,14,56,25);
        multilple(25,45,"Kasak","Rahul","Meena","tina");
    }

    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }

    static void mutliple(int a,int b, String ...v){
        System.out.println(a,b,v);
    }
}