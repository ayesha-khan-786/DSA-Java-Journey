import java.util.ArrayList;

public class Basic {

    public static void main(String args[]) {
       
       // Define ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Float> list3 = new ArrayList<>();
        ArrayList<Boolean> list4 = new ArrayList<>();

        // Operations
        // 1. Add Element  O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(5, 10);    // O(n)

        System.out.println(list);

        // 2. Get Element   O(1)
        int element = list.get(2);
        System.out.println(element);

        // 3. Remove Element O(n)
        list.remove(2);
        System.out.println(list);

        // 4. Set Element At Index O(n)
        list.set(2, 10);
        System.out.println(list);

        // 5. Contains Element
        boolean cont = list.contains(1);
        System.out.println(cont);

        boolean cont2 = list.contains(11);
        System.out.println(cont2);


    }
}