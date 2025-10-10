import java.util.*;

public class Matrices {

    // To find element 
    public static boolean search (int matrix[][] , int key) {
        for(int i=0 ; i < matrix.length ; i++) {
            for (int j=0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("key found at cell (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }
   
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int matrix[][] = new int[3][3];
        int n = matrix.length ,  m = matrix[0].length;  // rows & cols

        System.out.print("Enter a elements of matrix : ");
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // output
        for(int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // call search function
        search(matrix , 5);
    }
}