// Tower of Hanoi

public class Que5Hanoi {

    static void hanoi(int n, char A, char B, char C) {
        if (n == 0) {
            return;
        }
        hanoi( n-1, A, C, B);
        System.out.println("Move Disk : " + n + " from " +A + " to " + C);
        hanoi( n-1, B, A, C);
    }

    public static void main(String args[]) {
        hanoi(3, 'A', 'B', 'C');
    }
}