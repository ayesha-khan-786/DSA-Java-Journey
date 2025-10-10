import java.util.*;

public class Assignment {

// Q1. print no of 7's that are in array
    public static int search(int matrix[][] , int target) {
        int count = 0;
        for (int i=0 ; i<matrix.length ; i++) {
            for(int j=0 ; j<matrix[0].length ; j++) {
                if (matrix[i][j] == 7) {
                    count++;
                }
            }
        }
        return count;
    }

// Q2. print sum of 2nd row
    public static int sum(int matrix[][]) {
        int sum = 0;

          for (int j=0 ; j<matrix[0].length ; j++) {
                sum += matrix[1][j];
            }
        return sum;
    }

// Q3. transpose matrix
    public static void transpose(int matrix[][]) {
        for(int i=0 ; i<matrix[0].length ; i++) {
            for(int j=0 ; j<matrix.length ; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {{4 ,7 ,8},
                         {8, 8, 7}};
      // System.out.println("The target is repeated " + search(matrix , 7) + " times.");
      
     //  System.out.println("Sum of 2nd row is " + sum(matrix));

     transpose(matrix);
    }
}