public class SurroundedRegion{
    public static void solve(char[][] board) {
        if(board == null || board.length == 0) return ;
       int row= board.length;
       int col = board[0].length;

       for(int i =0; i < row; i++){
         dfs(board ,i , 0);// left col
         dfs(board , i , col-1);// right col
       }

       for(int j =0; j < col; j++){
        dfs(board,0, j); // top row
        dfs(board , row-1, j); // last row
       }

       for(int i = 0 ; i < row ; i++){
         for(int j = 0 ; j < col ; j++){
            if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }else if(board[i][j] == 'S') {
                board[i][j] = 'O';
            }
         }
       }

    }
    public  static void dfs(char[][] board , int r , int c){
        int row = board.length;
        int col = board[0].length;

        if( r >=row || c >= col || r <0 || c < 0 || board[r][c] != 'O' ){
            return ;
        }

        board[r][c] = 'S';

        dfs(board , r+ 1 , c);
        dfs(board, r-1,c);
        dfs(board , r, c+1);
        dfs(board , r , c-1);



    }

    public static void main(String[] args){
        char[][] board = {
            {'X','X', 'X', 'X'},
            {'X','O','O','X'},
            {'X', 'X' , 'O', 'O'},
            {'X', 'O','X', 'X'}
        };

        solve(board);
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }

}