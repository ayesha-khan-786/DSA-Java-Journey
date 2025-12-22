// Largest subarray with sum 0
import java.util.*;

public class LargestSunarray {

    public static void main(String args[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum. idx)

        int sum = 0;
        int len = 0;

        for(int j=0 ; j<arr.length ; j++) {
            sum += arr[j];      // i.e 1-> 0+15, 2->15-2, 3->13+2

            if(map.containsKey(sum)) {  // if sum exists in map
                len = Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("Largest subarray length with sum 0 : " + len);
    }
}

// TC = O(n)