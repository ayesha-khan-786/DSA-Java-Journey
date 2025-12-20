public class RecursionBasics {

// Print no n to 1 in Desending order
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);                // Base case
    }

// Print no 1 to n in increasing order
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    
    public static void main(String args[]) {
        int n = 10;
        printDec(n);
        printInc(n);
    }
}