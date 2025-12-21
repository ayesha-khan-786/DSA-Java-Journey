// Iterations on HashSet
import java.util.*;

public class Iterators {

    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
            cities.add("Delhi");
            cities.add("Mumbai");
            cities.add("Pune");
            cities.add("Noida");

        // Using Iterators
            Iterator it = cities.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }

        // using advance loop
        for (String city : cities) {
            System.out.println(city);
        }
    }
}