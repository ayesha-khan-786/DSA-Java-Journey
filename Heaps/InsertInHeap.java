import java.util.*;

public class InsertInHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

    // Step 1 -> add at last idx
        public void add(int data) {     // O(logn)
            // add at last idx
            arr.add(data);

    // Step 2 -> Fix heap -> i- calculate child & par
            int x = arr.size()-1;                   // x is child idx i.e last idx
            int par = (x-1) / 2;                    // parent idx

        // ii - swap  while child.val < par.val -> O(logn)
            while(arr.get(x) < arr.get(par)) {      
                // swap
                int temp = arr.get(x);              // temp = child
                arr.set(x, arr.get(par));           // child = par
                arr.set(par, temp);                 // par = temp
            }
        }
    }

    public static void main(String args[]) {

    }
}