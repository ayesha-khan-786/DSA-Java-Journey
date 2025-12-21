// Union And Intersection of 2 Arrays
import java.util.*;

public class UnionNIntersection {

    public static void main(String args[]) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        // Union
        // step 1 -> add arr1 ele in set
        for(int i=0 ; i<arr1.length ; i++) {
            set.add(arr1[i]);
        }
        // step 2 -> add arr2 ele in set
        for(int i=0 ; i<arr2.length ; i++) {
            set.add(arr2[i]);
        }

        // step 3 -> set store unique ele, so size of set = union
        System.out.println("Union -> " + set.size());

        // Intersection
        set.clear();
        // step 1 -> add arr1 ele in set
        for(int i=0 ; i<arr1.length ; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        // Step 2 -> check ele exist in set
         for(int i=0 ; i<arr2.length ; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection -> " + count);
    }
}