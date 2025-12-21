// TreeSet
import java.util.*;

public class TreeSET {

    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
            cities.add("Delhi");
            cities.add("Mumbai");
            cities.add("Pune");
            cities.add("Noida");
            System.out.println(cities);     // Display randomly

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
            lhs.add("Delhi");
            lhs.add("Mumbai");
            lhs.add("Pune");
            lhs.add("Noida");
            System.out.println(lhs);        // Display in inserted order
    
        TreeSet<String> ts = new TreeSet<>();
            ts.add("Delhi");
            ts.add("Mumbai");
            ts.add("Pune");
            ts.add("Noida");
            System.out.println(ts);         // Display in sorted asc order
    }
}