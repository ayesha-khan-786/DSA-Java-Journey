import java.util.*;

public class UpperCase {

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));                        // o idx ko uppercase me convert kiya
        sb.append(ch);                                                         // usko append kiya sb me
        for (int i=1 ; i<str.length() ; i++) {                                 // loop runs fron 1 idx to last 
            if(str.charAt(i) == ' ' && i < str.length()-1) {                                         // if space comes
                sb.append(str.charAt(i));                                      // then appen space to sb
                i++;                                                           // go next element after space
                sb.append(Character.toUpperCase(str.charAt(i)));               // convert into uppercase
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();        // convert sb to string
    }
   
    public static void main(String args[]) {
       String str = "hi, i am aisha";

      System.out.println(toUpperCase(str));
    }
}