// Climbing stairs using Tabulation -> O(n)
import java.util.*;
public class Climb_stair_memoization {

    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];        // 0 to n
        dp[0] = 1;

        for(int i=1 ; i<=n ; i++) {
            if(i == 1) {
                dp[i] = dp[i-1] + 0;        // i-1 i.e 0
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;      // n=3 -> 3 ways & n=4 -> 5 ways => Ans -> 8
        
        System.out.println(countWaysTab(n));
    }
}