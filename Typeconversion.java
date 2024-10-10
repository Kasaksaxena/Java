class Typeconversion
{
    public static void main(String args[])
    {
        int b=15;
        byte c=17;
        System.out.println(b);
        b=c;// implicit conversion
        System.out.println(b);
        System.out.println(c);
        // c=b can't possible directly but by explicit func
        c=(byte)b;
        System.out.println(c);
        //but when no exceeds the bytes limit it simply do modulo to no.
        int k=257;
        byte m=(byte)k;
        System.out.println(m);
        float f=5.7f;
        int g=(int)f;
        System.out.println(g);

        //type promotions
        byte h=15;
        byte i=30;
        int result=h*i;//out of range of bytes
        System.out.println(result);

    }
}