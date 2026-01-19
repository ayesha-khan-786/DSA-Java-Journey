// Longest Common Subsequence
import java.util.*;
public class LIS {

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        // Initialize
        for(int i=0 ; i<n+1 ; i++) {
            dp[i][0] = 0;
        }
        for(int j=0 ; j<m+1 ; j++) {
            dp[0][j] = 0;
        }

        // Bottom-up Approach
        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<m+1 ; j++) {
                if(arr1[i-1] == arr2[j-1]) {        // if no are same
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];          // dec length of 1st
                    int ans2 = dp[i][j-1];          // dec length of 2nd
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];        // last cell
    }
 
    public static int longestIncSubsequence(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();     // To store unique ele of arr in set
        for(int i=0 ; i<arr1.length ; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];       // store sorted unique ele
        int i=0;
        for(int num : set) {        // traverse and store num in arr2
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);       // Sort array in asc
        return lcs(arr1, arr2);

    }

    public static void main(String args[]) {
        int arr[] = {50, 3, 10, 7, 40, 80};

        System.out.println(longestIncSubsequence(arr));     // 4 -> 3, 10, 40, 80 & 3, 7, 40, 80
    }
}