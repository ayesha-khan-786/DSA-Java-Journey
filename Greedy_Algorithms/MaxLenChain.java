// Maximum length Chain of Pairs

import java.util.*;

public class MaxLenChain {

    public static void main(String args[]) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

    // Step 1 - Sort
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    // Step 2 - Pick first pair
        int chainLen = 1;
        int chainEnd = pairs[0][1];      // last selected pair end or chain end
    
    // Step 3 - start > end
        for(int i=1 ; i<pairs.length ; i++) {
            if(pairs[i][0]  > chainEnd) {       // start > cahinEnd
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max length of chain = " + chainLen);
    }
}

// Time Complexity = O(nlogn)