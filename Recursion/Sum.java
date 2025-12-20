public class Sum {

    public static int calcSum(int n) {
        if(n == 1) {
            return 1;
        }
        int Sum1 = calcSum(n-1);
        int Sn = n + Sum1;          // Sum of n = Sn
        return Sn;
    }

    public static void main(String args[]) {
        int n=5;
       System.out.println( calcSum(n) );
    }
}