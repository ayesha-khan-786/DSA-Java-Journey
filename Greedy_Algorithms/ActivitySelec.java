// Greedy Algorithm un-sorted - nlog(n)

import java.util.*;

public class ActivitySelec {

    public static void main(String args[]) {
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};

    // for sorting - 2D array
        int activities[][] = new int[start.length][3];  // size - n x 3
        for(int i=0 ; i<start.length ; i++) {
            activities[i][0] = i;                       // store idx
            activities[i][1] = start[i];                // store start pt
            activities[i][2] = end[i];                  // store end pt
        }

    // lambda function -> shortform of funct
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
    // 1st activity select A0
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];                       // end of A0

        for(int i=1 ; i<end.length ; i++) {
            if(activities[i][1] >= lastEnd) {                 // A0 end <= next activity
                // activity select
                maxAct++;                                     // inc count of activity
                ans.add(activities[i][0]);                    // add activity idx
                lastEnd = activities[i][2];                   // update lastEnd i.e curr activity end
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