// Sliding Window Maximum
import java.util.*;

public class SlidingWindow {

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
 
    @Override
    public int compareTo(Pair p2) {
        // To sort in ascending
        // return this.val - p2.val;

        // But we have to sort in descending
        return p2.val - this.val;
    }

    }

    public static void main(String args[]) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int res[] = new int[arr.length-k+1];        // n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Store 1st window elements
        for(int i=0 ; i<k ; i++) {
            pq.add(new Pair(arr[i], i));        // store val and idx
        }

        res[0] = pq.peek().val;

        for(int i=k ; i<arr.length ; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) {        // not exist in window
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));        // Add curr pair in PQ
            res[i-k+1] = pq.peek().val;         // res[window no]
        }

        // Print
        for(int i=0 ; i<res.length ; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}

// Output -> 3 3 5 5 6 7
// Time Complexity -> O(nlogk)