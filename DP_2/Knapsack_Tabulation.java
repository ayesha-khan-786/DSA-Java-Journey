// 0-1 Knapsack -> O(n * W)
public class Knapsack_Tabulation {

    public static int knapsackTab(int val[], int wt[], int W) {     // n = item
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0 ; i<dp.length ; i++){   // init = 0th col
            dp[i][0] = 0; 
        }

        for(int j=0 ; j<dp[0].length ; j++) {   // init = 0th row
            dp[0][j] = 0;
        }

        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<W+1; j++) {
                int v = val[i-1];   // i-1 = ith item vl
                int w = wt[i-1];    // i-1 = ith item wt
                if(w <= j) {        // valid 
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {    // invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp);
        return dp[n][W];        // last cell
    }

    public static void print(int dp[][]) {
        for(int i=0 ; i<dp.length ; i++) {
            for(int j=0 ; j<dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        

        System.out.println(knapsackTab(val, wt, W));       // 75
    }
}