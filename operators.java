class operators
{
    public static void main(String arg[])
    {
       //arithmetic operators
       int num1=7;

       //int num1+=1; 
       //int num1-=1;
       //int num1*=1;
       //int num1/=1;
       //int num1%=1;

       int result1=num1++;// post increment (fetch value then increment)
       int result2=++num1;//pre-increment (increment then fetch value)
       System.out.println(result1);
       System.out.println(result2);

       // Relational operators
       double x=800;
       double y=900;
       boolean resultx= x<=y;
       //boolean result= x==y;
       //boolean result= x>=y;
       boolean resulty= x!=y;
       System.out.println(resultx);
       System.out.println(resulty);

       //logical operators
       int a=5;
       int b=9;
       int c=5;
       int d=9;

       boolean resultbool=(a<d || b<c) && (a==c && b==9 );
       System.out.println(resultbool);
       System.out.println(!resultbool);

    }
}