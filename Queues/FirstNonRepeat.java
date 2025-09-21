// First non-repeating letter in a stream of characters

import java.util.*;

public class FirstNonRepeat {

    public static void printNonRepeating(String str) {

        // step - 1 - track 'a' - 'z' character
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        // step - 2 - traverse each character
        for(int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            q.add(ch);                      // add in queue
            freq[ch-'a']++;                 // convert in int n add in freq arr

        // step - 3 - find 1st non-repeating char
        while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
            q.remove();                     // if freq > 1 then remove it
        } 

        if(q.isEmpty()) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(q.peek() + " ");
        }
     }
     System.out.println();
    }

    public static void main(String args[]) {
        String str = "aabccxb";
        printNonRepeating(str);

    }
}