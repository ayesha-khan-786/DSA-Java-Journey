// 0-1 Knapsack -> O(n * W)
public class Knapsack_Memoization {

    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {     // n = item
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {        // store ans
            return dp[n][W];
        }

    // Valid
        if(wt[n-1] <= W) {      // n-1 = to get idx of each item
            // include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);        // n-1 bcoz v r traversing in reverse n to 0
            // exclude
            int ans2 = knapsack(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {    // not valid
            dp[n][W] = knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void main(String args[]) {
        int val[] = {5, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        // init dp

        for(int i=0 ; i<dp.length ; i++) {
            for(int j=0 ; j<dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W, val.length, dp));       // 75
    }
}