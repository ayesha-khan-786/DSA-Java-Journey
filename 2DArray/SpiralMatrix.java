import java.util.*;

public class SpiralMatrix {

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            // print top boundary
            for (int j=startCol ; j<=endCol ; j++) {
                System.out.print(matrix[startRow][j] + " ");    // startRow is fix i.e = 0
            }

            // print right boundary
            for ( int i=startRow+1 ; i<=endRow ; i++) {  // i=startRow +1 bcoz in top boundary last ele is print
                System.out.print(matrix[i][endCol] + " ");
            }

            // print bottom boundary
            for (int  j=endCol-1 ; j>=startCol ; j--) {
                if(startRow == endRow) {                     // if n*m is odd bcoz bichme 1 hi cell 2 br print na ho 
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // print left boundary
            for (int i=endRow-1 ; i>=startRow+1 ; i-- ) {
                 if(startCol == endCol) {                     // if n*m is odd bcoz bichme 1 hi cell 2 br print na ho 
                    break;
                 }
                System.out.print(matrix[i][startCol] + " ");
            }
            // updation
             startCol++;
             startRow++;
            endCol--;
            endRow--;
           
        }
        System.out.println();
    }
   
    public static void main(String args[]) {
     int matrix[][] = {{1 , 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

     printSpiral(matrix);
    }
}