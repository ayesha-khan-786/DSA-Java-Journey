import java.util.*;

public class PrimeFunction {

 //   public static boolean isPrime(int n) {
 //       boolean isPrime = true;

 //       for(int i=2 ; i<=n-1 ;i++) {
 //           if(n % i == 0) {
 //               isPrime = false;
 //               break;
 //           }
 //       }

  //      return isPrime;
  //  }

  // Optimized Method

  public static boolean isPrime(int n) {
    if(n == 2) {
        return true;
    }

      for(int i=2 ; i<=Math.sqrt(n) ; i++) {
        if(n % i == 0) {
            return false;
        }
      }
      return true;
  }

  // in range

  public static void primeInRange(int n) {
    for(int i=2 ; i<=n ; i++) {
       if( isPrime(i) ) {     // true
             System.out.print(i + " ");
       }
    }
    System.out.println();
  }

    public static void main(String args[]) {
       //  System.out.println(isPrime(16));
      primeInRange(50);
    }
}