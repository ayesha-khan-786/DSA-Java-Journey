// Sort by frequency
import java.util.*;

public class Q3 {

    public String freqSort(String s) {
        // Step 1 -> Count freq of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2 -> Store freq and char in alist of pair
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(map.entrySet());

        // Step 3 -> Sort list based on freq in desc order
        Collections.sort(freqList, (a,b)->b.getValue() - a.getValue());

        // Step 4 -> Build the result string based on frq
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : freqList) {
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count-- > 0) {
                result.append(ch);
            }
        }

        return result.toString();

    }

    public static void main(String args[]) {
        String s = "cccaaa";

        Q3 obj = new Q3();
        String result = obj.freqSort(s);

        System.out.println(result);
    }
}