import java.util.ArrayList;

public class MazeWithRestr {
   public static void main (String[] args){

    boolean
    maze[][]= {
        {true,true,true},
        {true,false,true},
        {true,true,true}
    };
      System.out.println(pathret("",maze, 0, 0));

      }


    static ArrayList<String>  pathret(String p,boolean[][] maze ,int r, int c ){
        if(r==maze.length-1 && c == maze[0].length-1){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        // if current cell is false(blocked) return an empty list we cant proceed from here
        if(!maze[r][c]){
            return new ArrayList<>();
       
        }
        ArrayList<String> list= new ArrayList<>();
        if(r<maze.length-1){
         list.addAll(pathret(p +'D',maze, r+1,c));
       
        }
        if(c<maze[0].length-1){
    
           list.addAll( pathret(p +'R',maze, r,c+1));
        
       
        
        }

        return list;
   
    
    }
}


