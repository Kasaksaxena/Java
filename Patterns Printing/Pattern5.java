public class Pattern5{
    public static void main(String[] args) {
        int n=5;
        Pattern(n);
        
    }
    static void Pattern(int n){
      for(int i=1;i<2*n;i++){
        int totalcolsinRow=i>n?2*n-i:i;
        for( int j=0;j<totalcolsinRow;j++){
            System.out.print("*");

        }
        System.out.println();
        

      }  
    }
}