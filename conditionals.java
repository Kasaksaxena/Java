class conditionals
{
   public static void main(String[] args) 
   {
     int x=7;
     int y=19;
     int z=12;

     if(x>y && x>z)
      System.out.println(x);
     else if(y>x && y>z)
      System.out.println(y);
     else
      System.out.println(z);

// ternary operators
      int n=8;
      int result=0;
      
       result = n%2==0?1:0;
      System.out.println(result);

// switch,default and break 
   int w=8;

   switch(w){
        case 1:
          System.out.println("Monday");
          break;
        case 2:
          System.out.println("Tuesday");
          break;
        case 3:
          System.out.println("Wednesday");
          break;
        case 4:
          System.out.println("Thursday");
          break;
        case 5:
          System.out.println("Friday");
          break;
        case 6:
          System.out.println("Satday");
          break;
        case 7:
          System.out.println("Sunday");
          break;
        default:
            System.out.println("Enter a valid number"); 
          

  for(int i=1;i<=4;i++)
  {
    System.out.println("Hello");
  }        

        
            

   }      

      
   }
}