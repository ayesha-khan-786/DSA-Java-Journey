// O(n) 
public class Fibonacci {

// Memoization
    public static int fib(int n, int f[]) {     // o(n)
        if(n == 0 || n == 1) {
            return n;
        }
        if(f[n] != 0) {     // fib(n) is already calculated
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
            return f[n];
    }

// Tabulation
    public static int fibTabulation(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];       // ans
    }

    public static void main(String args[]) {
        int n = 5;
        int f[] = new int[n+1];     // f[] -> To store fibonacci of all no's (init with 0)
        System.out.println(fib(n, f));
        System.out.println(fib(n, f));
    }
}