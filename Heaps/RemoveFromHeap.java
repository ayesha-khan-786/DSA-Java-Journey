import java.util.*;

public class RemoveFromHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {     
            arr.add(data);

            int x = arr.size()-1;                   // x is child idx i.e last idx
            int par = (x-1) / 2;                    // parent idx

            while(arr.get(x) < arr.get(par)) {      
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
        int minIdx = i;

        if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {      //left < arr.size() i.e check cond for leaf node i.e if left not exit
            minIdx = left;                                              // if minIdx > left
        }

        if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {    // if right not exit && right is small then minIdx
            minIdx = right;
        }

        if(minIdx != i) {
            // swap root to fix heap with minIdx
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapify(minIdx);        // where val is changed call there to fix heap there
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
        Heap h = new Heap();        // we can alse write as Heap pq = new Heap; o/p vl b same 
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}

// Output -> 1 3 4 5 