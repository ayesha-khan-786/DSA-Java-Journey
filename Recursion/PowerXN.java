public class PowerXN {

    public static int power(int x, int n) {
        if( n == 0) {
            return 1;
        }

    /*    int xnm1 = pow(x, n-1);     // xnmm1 = x to power n-1
        int xn = x * xnm1;          // x pow n = x * x to pow n-1
        return xn;  */

        // or

        return x * power(x, n-1);
    }

    public static void main(String args[]) {
        System.out.println(power(2, 10));
    }
}