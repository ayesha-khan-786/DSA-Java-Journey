// Greedy Algorithm sorted on basis of end points - O(n)

import java.util.*;

public class ActivitySelection {

    public static void main(String args[]) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // 1st activity select A0
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];                       // end of A0

        for(int i=1 ; i<end.length ; i++) {
            if(start[i] >= lastEnd) {               // A0 end <= next activity
                // activity select
                maxAct++;                           // inc count of activity
                ans.add(i);                         // add activity
                lastEnd = end[i];                   // update lastEnd i.e curr activity end
            }
        }
    
        System.out.println("Maximum activities = " + maxAct);

        // Print activity selected
        for(int i=0 ; i<ans.size() ; i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}