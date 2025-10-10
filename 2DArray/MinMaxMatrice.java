import java.util.*;

public class MinMaxMatrice {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int matrix[][] = new int[3][3];
        int n = matrix.length , m = matrix[0].length;

        int min = Integer.MAX_VALUE;

        System.out.println("Enter the elements of matrix : ");
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                matrix[i][j] = sc.nextInt();

                // min and max value
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Minimum value is : " + min);
    }
}