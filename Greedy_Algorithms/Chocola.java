import java.util.*;

public class Chocola {

    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};    // m-1
        Integer costHor[] = {4, 1, 2};          // n-1

    // Step 1 - Sort cost
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

    // Step 2 - Initialize cuts & peices
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

    // Step 3 - Traverse Array
        while(h < costHor.length && v < costVer.length) {
            // case 1 - vertical cost < hor cost => then hor cut
            if(costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            // case 2 - hor cost < ver cost => then ver cut
            else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

    // Step 4 - Remaining cuts
        while(h < costHor.length) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
        }

        while(v < costVer.length) {
                cost += (costVer[v] * hp);
                vp++;
                v++;
        }

        System.out.println("Minimum cost of cuts : " + cost);
    }
}