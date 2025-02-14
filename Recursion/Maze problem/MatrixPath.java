import java.util.ArrayList;
import java.util.Arrays;

public class MatrixPath {
    public static void main (String[] args){
        boolean
        maze[][]= {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] path= new int[maze.length][maze[0].length];
        pathret("",maze, 0, 0,path,1);

    }
    static ArrayList<String>  pathret(String p,boolean[][] maze ,int r, int c,int[][] path, int step ){
        if(r==maze.length-1 && c == maze[0].length-1){
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
                System.out.println(p);
                
            }
            System.out.println();
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        // if current cell is false(blocked) return an empty list we cant proceed from here
        if(!maze[r][c]){
            return new ArrayList<>();
       
        }

        // mark the cell as visited
        maze[r][c]=false;
        path[r][c]=step;
        ArrayList<String> list= new ArrayList<>();
        if(r<maze.length-1){
         list.addAll(pathret(p +'D',maze, r+1,c,path,step+1));
       
        }
        if(c<maze[0].length-1){
    
           list.addAll( pathret(p +'R',maze, r,c+1,path,step+1));
        }
        if(r>0){
          list.addAll( pathret(p +'U',maze, r-1,c,path,step+1));
         }
        
         if(c>0){
            list.addAll( pathret(p +'L',maze, r,c-1,path,step+1));
           }
        // this line where func will be over
        // so before function gets removed, also remove the changes that were made by previos call
        maze[r][c]=true; 
        path[r][c]=0;  
        return list;
 
        }
    
    
}
