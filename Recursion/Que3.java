// Question 3 : Write a program to find Length of a String using Recursion

public class Que3 {
    
    public static int length(String str) {
        if(str.length() == 0) {
            return 0;
        }

        int  smallLength = length(str.substring(1));
        int totalLength = smallLength + 1;
        return totalLength;
    }
   
    public static void main(String args[]) {
        String str = "abcd";
        
        System.out.println(length(str));
    }
}