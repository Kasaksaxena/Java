public class Countingpaths {
    public static void main(String[] args){
        
       System.out.println( Maze(3,3));
    }
    static int Maze(int r, int c){
        if(r == 1 || c==1){
            return 1;
        }
        int left =Maze(r-1,c);
        int right=Maze(r,c-1);

        return left + right;

    }
    
}
