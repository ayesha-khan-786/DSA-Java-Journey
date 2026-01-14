// Climbing stairs using Memoization DP -> O(n)
import java.util.*;
public class Climb_stair_memoization {

    public static int countWays(int n, int ways[]) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }

        if(ways[n] != -1) {     // it is already init with -1
            return ways[n];
        }

        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];
    }

    public static void main(String args[]) {
        int n = 5;      // n=3 -> 3 ways & n=4 -> 5 ways => Ans -> 8
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);      // Initialize ways[] with -1 for each idx
        
        System.out.println(countWays(n, ways));
    }
}