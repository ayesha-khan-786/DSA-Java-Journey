import java.util.*;

public class BasicFunction {
    
    public static void printHelloWorld() {
       System.out.println("Hello World");
       return;
    }

    public static int calculateSum(int a , int b) { // Parameters or formal parameters
        int sum = a + b;
       return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
       //  printHelloWorld();
       int a = sc.nextInt();
       int b = sc.nextInt();
       int sum = calculateSum(a,b);  // Argumrnts or actual parameter
       System.out.println("Sum is " + sum);
    }
}