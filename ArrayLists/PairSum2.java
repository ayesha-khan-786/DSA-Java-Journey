// Find if any pair in Sorted & Rotated ArrayList has a target sum
// 2 Pointer Approach
import java.util.*;

public class pairSum2 {

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int breakingPt = -1;
        int n = list.size();
        
        for(int i=0 ; i<list.size() ; i++) {
            if(list.get(i) > list.get(i+1)) {   // breaking pt
                breakingPt = i;
                break;
            }
        }

        int lp = breakingPt + 1;       // smallest value
        int rp = breakingPt;

        while(lp != rp) {
            // case 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case 2
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp -1) % n;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();
        // 11, 15, 6, 8, 9, 10
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;

        System.out.println(pairSum2(list, target));
    }
}