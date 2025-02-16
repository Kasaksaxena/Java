public class Nqueens{
    public static void main(String[] args) {
        boolean[][] board= new boolean[4][4];
        int sol=queens(board,0);
        System.out.println("Total solutions: "+sol);
        
    }

    static int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        // placing the queen and checking for every row and col
        for(int col=0;col<board[0].length;col++){
            // place queen if it is safe
            if(isSafe(board,row,col)){
                board[row][col]=true;//place queen
                count+=queens(board,row+1);// move to next row
                board[row][col]=false;// backtract(remove queen)
            }
        }
        return count;
    }
    private static boolean isSafe(boolean[][] board,int row, int col){// checking attacks
        //check column above
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        // check left diagonal
        int maxleft=Math.min(row,col);
        for(int i=1;i<=maxleft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        // check right diagonal
        int maxright=Math.min(row,board[0].length-col-1);
        for(int i=1;i<=maxright;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;// if no attack return true
    }

    private static void display(boolean[][] board){
        for(boolean[] row: board){
            for(boolean col:row){
                if(col){// if true print Q else X
                    System.out.print("Q");
            }
            else{
                System.out.print("X");
            }

        }
        System.out.println();// move to next line after every row
    }
}
}