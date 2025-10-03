// Minimum Absolute Difference Pair

import java.util.*;

public class MinAbsDiff {

    public static void main(String args[]) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

    // Step 1 - Sort
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

    // Step 2 - Calculate abs diff
        for(int i=0 ; i<A.length ; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Min Absolute diff of pairs : " + minDiff);
    }
}

// Time Complexity = O(nlogn)