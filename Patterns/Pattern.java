import java.util.*;

public class Pattern {

// Hollow Rectangle   
    public static void hollow_rectangle(int rows , int cols) {
     for ( int i = 1 ; i <= rows ; i++ ) {
         for ( int j = 1 ; j <= cols ; j++ ) {
            if ( i == 1 || i == rows || j == 1 || j == cols ) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
         }
         System.out.println();
     }
    }

// Inverted half pyramid
    public static void inverted_half_pyramid(int n) {
        // Outer
        for ( int i=1 ; i <= n ; i++) {
           
            //Spaces
            for (int j=1 ; j <= n-i ; j++) {
                System.out.print(" ");
            }
            
            //Star
            for (int k=1 ; k<=i ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

// Inverted half pyramid with Numbers
    public static void inverted_half_pyramid_numbers( int n ) {
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= n-i+1 ; j++ ) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

// Floyd's Triangle
    public static void floyds_triangle( int n ) {
        int counter = 1;
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j = 1 ; j <= i ; j++ ) {
                System.out.print( counter+ " ");
                counter++ ;
            }
            System.out.println();
        }
    }

// Zero-one triangle
    public static void zero_one_tri( int n ) {
        for ( int i = 1 ; i <= n ; i++ ) {
            for ( int j=1 ; j <= i ; j++) {
                if((i+j) % 2 == 0) {
                    System.out.print(1+" ");
                } else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }

// Butterfly Pattern

    public static void butterfly(int n) {
        // 1st half
        for(int i=1 ; i<=n ; i++) {
            //stars = i
        for(int j=1 ; j<=i ; j++) {
            System.out.print("*");
        }
           
            //spaces = 2*(n-i)
        for(int j=1 ; j<=2*(n-i) ; j++) {
            System.out.print(" ");
        }

            //stars = i
        for(int j=1 ; j<=i ; j++) {
            System.out.print("*");
           }
           System.out.println();
        }
      
        // 2nd Half
        for(int i=n ; i>=1 ; i--) {
            //stars = i
             for(int j=1 ; j<=i ; j++) {
            System.out.print("*");
        }
           
            //spaces = 2*(n-i)
        for(int j=1 ; j<=2*(n-i) ; j++) {
            System.out.print(" ");
        }

            //stars = i
        for(int j=1 ; j<=i ; j++) {
            System.out.print("*");
           }
            System.out.println();
        }
    }

// Solid Rhombus Pattern

    public static void rhombus(int n) {
        for (int i=1 ; i <=n ; i++) {
           
            for(int j=1 ; j<=(n-i) ; j++) {    //spaces
                System.out.print(" ");
            }
           
            for(int k=1 ; k<=n ; k++) {       //stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

// Hollow Rhombus
    
    public static void hollow_rhombus(int n) {
        for (int i=1 ; i<=n ; i++) {
           
            for(int j=1 ; j<=(n-i) ; j++) {    //spaces
                System.out.print(" ");
            }

            for(int j=1 ; j<=n ; j++) {        // hollow rectangle
               if(i == 1 || i == n || j ==1 || j == n ) {
                  System.out.print("*");
               } else {
                System.out.print(" ");
               }
            }
            System.out.println();
        }
    }

// Diamond pattern

    public static void diamond(int n) {
        // 1st half
        for (int i=1 ; i<=n ; i++) {
          
            for (int j=1 ; j<=(n-i) ; j++) {   //spaces
                System.out.print(" ");
            }
           
            for (int j=1 ; j<=((2*i)-1) ; j++) {   //stars
                System.out.print("*");
            }
             System.out.println();
        }
       // 2nd half
        for (int i=n ; i>=1 ; i--) {
          
            for (int j=1 ; j<=(n-i) ; j++) {   //spaces
                System.out.print(" ");
            }
           
            for (int j=1 ; j<=((2*i)-1) ; j++) {   //stars
                System.out.print("*");
            }
             System.out.println();
        }
    }

    public static void main(String args[]) {
      //   hollow_rectangle(4, 5);
      //   inverted_half_pyramid(4);
      //   inverted_half_pyramid_numbers(5);
      //   floyds_triangle(5);
      //   zero_one_tri(5); 
      //   butterfly(4);
      //   rhombus(5);
      //   hollow_rhombus(5);
            diamond(4);
        
    }
}
