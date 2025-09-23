import java.util.*;

public class FractionalKnapsack {

    public static void main(String args[]) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

    // Step 1 - Sort Ratio -> 2D -> 0th col: idx , 1th col: ratio
        double ratio[][] = new double[val.length][2];

        for(int i=0 ; i<val.length ; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
            
        }
        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;

        // Sort in descending order
        for(int i=ratio.length-1 ; i>=0 ; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {           // include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Value : " + finalVal);

    }
}