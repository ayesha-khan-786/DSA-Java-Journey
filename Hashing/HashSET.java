// HashSet Operations -> Store Unique 
import java.util.*;

public class HashSET {

    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        // add
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);

        // contains
        if(set.contains(2)) {
            System.out.println("Set contains 2");
        } 
        if(set.contains(3)) {
            System.out.println("Set contains 3");
        }

        set.remove(2);
        if(set.contains(2)) {
            System.out.println("Set contains 2 after remove");
        } 

        // size
         System.out.println(set.size());

        // clear
        set.clear();
        System.out.println(set.size());

        // isEmpty
        System.out.println(set.isEmpty());
    
    }
}