import java.util.*;

public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);       // push new data at bottom
            return;
        }
       // Remove from top
        int top = s.pop();      
        pushAtBottom(s, data);

        // push removed data
        s.push(top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

// Time Complexity = O(n)