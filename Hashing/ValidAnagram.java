// Valid Anagram -> Given 2 strings s & t, return true if t is an Anagram of s
import java.util.*;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length() ; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0 ; i<t.length() ; i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {                   // if t char exist in map
                if(map.get(ch) == 1) {                  // if freq = 1
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);       // freq--
                }
            } else {
                return false;                           // t char not present in s
            }
        }

        return map.isEmpty();
    }

    public static void main(String args[]) {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));
    }
}

// Time Complexity -> O(n)