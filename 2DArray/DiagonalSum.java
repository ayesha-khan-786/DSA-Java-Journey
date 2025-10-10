import java.util.*;

// only for n=m i.e size of rows & cols are same

public class DiagonalSum {
    
    public static int diagonalSum(int matrix[][]) {
          int sum = 0;

          // primary diagonal
          // here over lapping condition is covered . Time c = O(n^2)
       
    /*      for(int i=0 ; i<matrix.length ; i++) {
            for (int j=0 ; j<matrix[0].length ; j++) {
                if(i == j) {
                    sum += matrix[i][j];
                } 
                else if (i + j == matrix.length-1) {
                    sum += matrix[i][j];
                }
            }
          }     */

        // if we have n odd
        
         for (int i=0 ; i<matrix.length ; i++) {
            // primary d
            sum += matrix[i][i];
            // secondary d
            if( i != matrix.length-1-i) {   // i != j bcoz if i = j then it is already add in primary d
                sum += matrix[i][matrix.length-i-1];  // i+j=n-1 ; j=n-i-1
        
           }    
         }
          return sum;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1 , 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};
                        
     System.out.println( diagonalSum(matrix));
    }
}