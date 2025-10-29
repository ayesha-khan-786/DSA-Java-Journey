// conver uppercase to lowercase

public class Q4 {

    public static void converUpperCaseToLowerCase() {
        for (char ch = 'A' ; ch <= 'Z' ; ch++) {
            System.out.println((char)(ch|' '));
        }
    }

    public static void main(String args[]) {
       converUpperCaseToLowerCase();
    }
}