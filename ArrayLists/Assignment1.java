// Monotonic ArrayList

import java.util.*;

public class Assignment1 {

    public static boolean monotonicArrayList(ArrayList<Integer> M ) {
        boolean inc = true;
        boolean dec = true;

        for(int i=0 ; i<M.size()-1 ; i++) {
            if(M.get(i) > M.get(i+1)) {
                inc = false;
            } 
            if(M.get(i) < M.get(i+1)) {
                dec = false;
            }
        }

        return inc || dec;
    }

    public static void main(String args[]) {
        ArrayList<Integer> M = new ArrayList<>();
        M.add(1);
        M.add(2);
        M.add(2);
        M.add(3);
       System.out.println(M);

        System.out.println(monotonicArrayList(M));
    }
}