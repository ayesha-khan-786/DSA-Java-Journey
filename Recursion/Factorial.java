public class Factorial {

    public static int fact(int n) {
        if( n == 0 ) {
            return 1;
        }
        int fnm1 = fact(n-1);  // fnm1 = fact n minus 1
        int fn = n * fnm1;     // fn = factorial number
        return fn;
    }

    public static void main(String args[]) {
        int n = 3;
       System.out.println( fact(n));

    }
}