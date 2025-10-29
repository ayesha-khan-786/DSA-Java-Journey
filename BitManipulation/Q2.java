// Swap two numbers without using third variabe

public class Q2 {

    public static void main(String args[]) {
        int a = 5, b=6;
        System.out.println("Before swap: a = " + a + " and b = " + b);

         a = a ^ b;
         b = a ^ b;
         a = a ^ b;


        System.out.println("After swap: a = " + a + " and b = " + b);
    }
}