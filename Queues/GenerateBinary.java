// Generate Binary No's

import java.util.*;

public class GenerateBinary {

   static void generatePrintBinary(int n) {
     Queue<String> q = new LinkedList<>();
     q.add("1");                                // add 1st ele in queue

    while(n --> 0) {
        String s1 = q.peek();                   
        q.remove();
        System.out.println(s1);                 // print 1st element
       
        String s2 = s1;
        q.add(s1 + "0");
        q.add(s2 + "1");
    }
   }

    public static void main(String args[]) {
        int n = 10;
        generatePrintBinary(n);
    }
}