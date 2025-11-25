import java.util.*;

public class SubString {

    public static String subString(String str, int si , int ei) {
        String substr = "";

        for (int i=si ; i<ei ; i++) {
            substr += str.charAt(i);   // concatenate
        }
        return substr;
    }

    public static void main(String args[]) {
        
        String str = "Hello World";

       // System.out.println(subString(str , 0 , 5));
      
       // already defined in java substring
       System.out.println(str.substring(0 , 5));
    }
}