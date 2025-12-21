// Que 2 : u r given a no(eg-2019), convert it into String of eng like "two zero one nine". Use a recursive function to solve. note : digit of no will be range 0-9

public class Que2 {
     
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void printWords(int n) {
        if(n == 0) {
            return;
        }
        int lastDigit = n % 10;
        printWords(n / 10);
        System.out.print(digits[lastDigit] + " ");
    } 
    
    public static void main(String args[]) {
        int n = 1996;
        printWords(n);
    }
}