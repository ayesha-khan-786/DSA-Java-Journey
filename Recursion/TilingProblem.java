public class TilingProblem {

    public static int tilingProblem(int n) { // floor size = 2 * n
    // Base case
    if(n == 0 || n == 1) {
        return 1;
    }

    // kaam = choice 
    // vertical choice
    int fnm1 = tilingProblem(n-1);  // f(n-1) = fnm1

    // horizontal choice
    int fnm2 = tilingProblem(n-2);

    // Total ways
    int totalWays = fnm1 + fnm2;

    return totalWays;
    }

    public static void main(String args[]) {
        System.out.println(tilingProblem(2));
    }
}