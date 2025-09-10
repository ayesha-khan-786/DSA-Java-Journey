import java.util.*;

public class DuplicateParentheses {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);

            // case 1: closing
            if(ch == ')') {
                int count = 0;
                while( s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;    // duplicate exists
                } else {
                    s.pop();        // opening pair
                }
            } else {
                 // case 2: opening bracket, operator, operands
                 s.push(ch);
            }    
        }
        return false;
    }

    public static void main(String args[]) {
        // Valid string
        String str1 = "((a+b))";     // true
        String str2 = "(a-b)";       // false;
        System.out.println(isDuplicate(str1));
    }
}

// Time Complexity = O(n)