// Minimum Partitioning -> O(n * W)
import java.util.*;

public class Min_Partitioning {

    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;

        // Step 1 -> Sum of all ele in arr
        for(int i=0 ; i<arr.length ; i++) {
            sum += arr[i];
        }

        int W = sum/2;

        // Step 2 -> 0-1 Knapsack code
        int dp[][] = new int[n+1][W+1];
        // initialize
        if(n == 0 || W == 0) {
            return 0;
        }
        // bottom-up approach
        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<W+1 ; j++) {
                // valid
                if(arr[i-1] <= j) {
                    // include || exclude
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                } else {    //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // Step 3
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String args[]) {
        int nums[] = {1, 6, 11, 5};

        System.out.println(minPartition(nums));     // 11+1 - 6+5 = 1
    }
}