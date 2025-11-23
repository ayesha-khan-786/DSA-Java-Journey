import java.util.*;

public class maxHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {     
            arr.add(data);

            int x = arr.size()-1;                   // x is child idx i.e last idx
            int par = (x-1) / 2;                    // parent idx

            while(arr.get(x) > arr.get(par)) {      
                int temp = arr.get(x);              // temp = child
                arr.set(x, arr.get(par));           // child = par
                arr.set(par, temp);                 // par = temp
           
            // update
                x = par;
                par = (x-1)/2;
            }
        }

    public int peek() {
        return arr.get(0);
    }

    private void heapify(int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < arr.size() && arr.get(maxIdx) < arr.get(left)) {      //left < arr.size() i.e check cond for leaf node i.e if left not exit
            maxIdx = left;                                              // if maxIdx > left
        }

        if(right < arr.size() && arr.get(maxIdx) < arr.get(right)) {    // if right not exit && right is small then maxIdx
            maxIdx = right;
        }

        if(maxIdx != i) {
            // swap root to fix heap with minIdx
            int temp = arr.get(i);
            arr.set(i, arr.get(maxIdx));
            arr.set(maxIdx, temp);

            heapify(maxIdx);        // where val is changed call there to fix heap there
        }
    }

    public int remove() {
        int data = arr.get(0);

        // Step 1 -> swap 1st & last
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

        // Step 2 -> Remove last
        arr.remove(arr.size()-1);

        // Step 3 -> Heapify 
        heapify(0);
        return data;
    }
    

    public boolean isEmpty() {
        return arr.size() == 0;
    }
}
    public static void main(String args[]) {
        Heap pq = new Heap();         
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}

// Output -> 5 4 3 1 