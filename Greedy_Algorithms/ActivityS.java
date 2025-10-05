// Greedy Algorithm un-sorted - nlog(n)

import java.util.*;

public class ActivityS {

    public static void main(String args[]) {
        int[][] meets = new int[6][];
         meets[0] = new int[]{1, 20};
         meets[1] = new int[]{5, 10};
         meets[2] = new int[]{15, 18};
         meets[3] = new int[]{20, 30};
         meets[4] = new int[]{32, 38};
         meets[5] = new int[]{30, 35};

    // Comparator
        Arrays.sort(meets, (a, b) -> a[1] - b[1]);
        int last = -1, count = 0;

        for(int idx=0 ; idx < meets.length ; idx++) {
            if(meets[idx][0] > last) {                 
                count++;                                     
                last = meets[idx][1];                  
            }
        }
    
        System.out.println("Maximum activities = " + count);
    }
}