public class CountNQueens {

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for(int i=row-1 ; i>=0 ; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left up
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i--,j--) {
             if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right up
        for(int i= row-1 , j= col+1 ; i>=0 && j<board.length ; i--, j++) {
              if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        // Base Case
            if(row == board.length) {
            count++;
                return true;
            }
     
        // jis b row pr hu us col pr jakar queen ko bithana h
                
        for(int j=0 ; j<board.length ; j++) {
        if(isSafe(board, row, j)) {
            board[row][j] = 'Q';            // in 1 row only 1 Q
           if(nQueens(board, row+1)) {      // if n-1 Queens for place karna possible h
                return true;
           }        
            board[row][j] = 'x';            //  backtrap remove that queen bcoz in 1 row only 1 queen
           }
           
        }
        return false;
    }

    public static void printBoard(char board[][]) {
         System.out.println("--------Chess Board---------");
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board.length ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];

        // initialize
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                board[i][j] = 'x';
            }
        }

        if(nQueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
       // System.out.println("Total no of ways to solve N Queens are : " + count);
    }
}