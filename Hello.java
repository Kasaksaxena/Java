class Hello
{
    public static void main(String a[])
    {
        int num1=5;// 4 bytes
        byte num2=4;// 1 byte

        float result=num1+num2; 
        
        short sh=558;//2 bytes
        long l=5854l;//8 bytes,must have l
        
        float f=54.8f;// 4 bytes,must have f
        double d=58.4;//8 bytes,default parameter
        
        char c='k';// 2 bytes
        boolean b=true;// only true and false treated as bool not (0,1)

        // binary no.
        int num3=0b101;
        //hexa decimal
        int num4=0x7E;
        //print alphabets
        char e='a';
        e++;
        System.out.println("hello world");
        System.out.println(sh);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(e);
    }
}