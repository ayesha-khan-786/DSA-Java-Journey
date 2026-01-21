// Catalan's No using Tabulation -> O(n^2)
import java.util.*;

public class Catalan_Tabulation {

    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2 ; i<=n ; i++) {     // calculate Ci
            for(int j=0 ; j<i ; j++) {
                dp[i] += dp[j] * dp[i-j-1];     // Ci = Cj * Ci-j-1
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(catalanTab(n));
    }
}