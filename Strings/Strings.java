import java.util.*;

public class Strings {
  
    // To print all string letters
    public static void print(String str) {
        for(int i=0 ; i<str.length() ; i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }
   
    public static void main(String args[]) {

        // How to declare string

        String str = "abcd";
        String str2 = new String("xyz");

        // Input & Output
/*
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.next();
        System.out.println(name);

        String name2;
        name2 = sc.nextLine();
        System.out.println(name2);

*/
    // String Length
/*       String fullName = "Aisha Khan";
        System.out.println(fullName.length());
*/
    
    // String concatenate
    String firstName = "Ayesha";
    String lastName = "Khan";
    String fullName = firstName + " " + lastName;
/*    System.out.println(fullName);
    System.out.println(fullName.charAt(4));      // charAt method
 */   

     print(fullName);
    }
}