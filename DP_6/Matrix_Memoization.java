// Matrix Chain Multiplication -> O(n^2)
import java.util.*;

public class Matrix_Memoization {

    public static int mcm(int arr[], int i, int j, int dp[][]) {        // i-> starting pt, j-> ending pt
        if(i == j) {            // single matrix case
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i ; k<=j-1 ; k++) {       // k-> partition pt
            int cost1 = mcm(arr, i, k, dp);     // Ai......Ak , result size => arr[i-1] X arr[k]
            int cost2 = mcm(arr, k+1 , j, dp);   // Ak+1.....Aj, result size => arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;     // min cost
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3};    // n = 5
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialize
        for(int i=0 ; i<n ; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcm(arr, 1, n-1, dp));       // 30
    }
}