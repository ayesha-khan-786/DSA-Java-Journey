import java.util.*;

public class StringCompresion {

    public static String compress(String str) {

// using + operator
/*        String newStr = "";

        for(int i=0 ; i<str.length() ; i++) {
            Integer count = 1;   // int not integer bcoz we hve to add in string
           
           // compare current letter & next letter
           while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
             count++;
             i++;
           }
           newStr += str.charAt(i);
           if(count > 1) {
               newStr += count.toString();
              
           }
        }
         return  newStr;
    }
*/ 

// using StringBuilder
      StringBuilder sb = new StringBuilder();
       
        for(int i=0 ; i<str.length() ; i++) {
            Integer count = 1;  
           
           while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
             count++;
             i++;
           }
              sb.append(str.charAt(i));
        
           if(count > 1) {
               sb.append(count);
           }
        }
         return  sb.toString();
    }

    public static void main(String args[]) {
        String str = "aaabbccdd";

        System.out.println(compress(str));
    }
}