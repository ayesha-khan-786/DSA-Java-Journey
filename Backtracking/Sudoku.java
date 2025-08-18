public class Sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // column
        for(int i=0 ; i<=8 ; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        // Row
        for(int j=0 ; j<=8 ; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        // Grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        // 3x3 grid
        for(int i=sr ; i<sr+3 ; i++) {
            for(int j=sc ; j<sc+3 ; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case
        if(row == 9 ) {
            return true;
        } 

        // Recursion
        int nextRow = row, nextCol = col+1;
            if(col+1 == 9) {                    // when col reach 9 go to next row
            nextRow = row + 1;
            nextCol = 0;                        // col again starts from 0
        }

        // condition for already set ele
        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        
        // condition to place digit at new cell
        for(int digit=1 ; digit<=9 ; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)) {        // solution exists
                    return true;
                }
                 sudoku[row][col] = 0;  // if returns false don't place ele here
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3},
        };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exists");
        }
    }
}