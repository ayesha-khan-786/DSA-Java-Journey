// Target Sum Subset (Tabulation) -> O(n * sum)
public class Target_Sum {

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i = items, j = target sum
        for(int i=0 ; i<n+1 ; i++) {
            dp[i][0] = true;            // init 0th col -> true, & 0th row -> false(by default)
        }

        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<sum+1 ; j++) {
                int v = arr[i-1];           // v -> each particular number
                // include
                if(v <= j && dp[i-1][j-v] == true) {        // v <= j i.e each number == sum -> true
                    dp[i][j] = true;                        // dp[i-1][j-v] i.e after include remaining space(j-v) vl occupy by next item(i-1)
                }
                // exclude
                else if(dp[i-1][j] == true) {               // if each item(i-1) == target sum -> true 
                    dp[i][j] = true;
                } 
            }
        }
        print(dp);
        return dp[n][sum];      // last cell
    }

    public static void print(boolean dp[][]) {
        for(int i=0 ; i<dp.length ; i++) {
            for(int j=0 ; j<dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;                   // True

        System.out.println(targetSumSubset(arr, sum));
    }
}