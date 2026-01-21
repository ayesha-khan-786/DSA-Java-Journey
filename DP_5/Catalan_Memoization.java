// Catalan's Number using Memoization
import java.util.*;

public class Catalan_Memoization {

    public static int catalanMem(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }
        
        int ans = 0;       
        for(int i=0 ; i<=n-1 ; i++) {
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    public static void main(String args[]) {
        int n = 4;
        int dp[] = new int[n+1];

        Arrays.fill(dp, -1);        // Initialize all idx of array with -1

        System.out.println(catalanMem(n, dp));      // 14
    }
}