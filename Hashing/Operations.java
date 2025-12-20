import java.util.*;

public class Operations {

    public static void main(String args[]) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Indonesia"));        // null

        // Containskey - O(1)
         System.out.println(hm.containsKey("India"));

         System.out.println(hm.containsKey("Indonesia"));   // false

        // Remove - O(1)
        System.out.println(hm.remove("China"));             // 150
    
        System.out.println(hm);

        // Size
        System.out.println(hm.size());                      // 2
    
        // Is Empty
        System.out.println(hm.isEmpty());   

        // Clear
        hm.clear();
        System.out.println(hm.isEmpty());                   // true
    }   

}