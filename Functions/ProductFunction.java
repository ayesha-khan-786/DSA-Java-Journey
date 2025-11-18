import java.util.*;

public class ProductFunction {

    public static int multiply(int a , int b) {
        int product = a * b;
        return product;
    }

    public static int factorial(int n){
        int fact = 1;
          for(int i = 1 ; i <= n ; i++) {
            fact = fact * i;
          }
          return fact;
    }

    public static int binomialCoefficient(int n , int r) {
         int fact_n = factorial(n);
         int fact_r = factorial(r);
         int fact_nmr = factorial(n-r);

         int binCoeff = fact_n / (fact_r * fact_nmr);
         return binCoeff;
    }

    public static void main(String args[]) {
        int a = 3;
        int b = 5;
        int result = multiply(3, 5);
        System.out.println("Product is " + result);
     
       int n = 4;
       int result = factorial(7);
       System.out.println(result);
// OR  System.out.println(factorial(4));

       System.out.println(binomialCoefficient(5, 2));
    }
}