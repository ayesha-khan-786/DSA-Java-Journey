import java.util.*;

public class NextGreaterEle {

    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i=arr.length-1 ; i>=0 ; i--) {
           
            // 1. while loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {        // [s.peek] = idx & arr[] = ele at that idx
                s.pop();
            }

            //2 . if stack.empty
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // 3. push(idx)
            s.push(i);  

        }

        for(int i=0 ; i<nextGreater.length ; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}

// Time complexity = O(n)