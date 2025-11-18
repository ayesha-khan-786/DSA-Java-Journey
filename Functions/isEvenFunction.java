import java.util.*;

public class Assignment1 {

    public static boolean isEven(int a) {
        boolean isEven = true;
        if(a % 2 == 0) {
            isEven = true;
            System.out.println("Number is Even");
        } else {
            isEven = false;
              System.out.println("Number is Odd");
        }
        return isEven;
    }
   
   public static void main (String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a number : ");
    int a = sc.nextInt();

    System.out.println("Result is : ");
    System.out.println(isEven(a));

   }
   
}