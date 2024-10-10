public class Pattern28{
    public static void main(String[] args) {
        int n=5;
        Pattern(n);
        
    }
    static void Pattern(int n){
      for(int i=0;i<2*n;i++){
        int totalcolsinRow=i>n?2*n-i:i;

        int totalnoofspaces=n-totalcolsinRow;
        for( int s=0;s<totalnoofspaces;s++){
            System.out.print("#");

        }
        for( int j=0;j<totalcolsinRow;j++){
            System.out.print("*");

        }
        System.out.println();
        

      }  
    }
}