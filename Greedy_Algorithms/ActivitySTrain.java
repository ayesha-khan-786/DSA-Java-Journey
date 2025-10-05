// Greedy Algorithm un-sorted - nlog(n) -> Train n Platform management Solution

import java.util.*;

public class ActivityS {

    public static void main(String args[]) {
        int n = 6;
        int[][] trains = new int[n][];
         trains[0] = new int[]{900, 1100};
         trains[1] = new int[]{1000, 1400};
         trains[2] = new int[]{1130, 1230};
         trains[3] = new int[]{1400, 1600};
         trains[4] = new int[]{1200, 1500};
         trains[5] = new int[]{1500, 1800};

   
        int[] arrival = new int[n];
        int[] departure = new int[n];

        for(int idx = 0; idx < n ; idx++) {
            arrival[idx] = trains[idx][0];
            departure[idx] = trains[idx][1];
        }
    
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int currTrains = 0, platformReq = 0;

       int p1 = 0, p2 = 0;      // p1 = arrival train

       while(p1 < n) {
            if(arrival[p1] <= departure[p2]) {
                currTrains++;
                platformReq = Math.max(platformReq, currTrains);
                p1++;
            } else {
                currTrains--;
                p2++;
            }
       }
    
        System.out.println("Maximum platform required = " + platformReq);
    }
}

// Ans => 3 platforms required ( arrival matters , departure doesn't mattters)