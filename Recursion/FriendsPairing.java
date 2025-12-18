public class FriendsPairing {

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        //choice
        // 1.single
        int fnm1 = friendsPairing(n-1);     // f(n-1)

        // 2.pair
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1) * fnm2;

        // total ways
        int totalWays = fnm1 + pairWays;

        return totalWays;

        // Or second ways we can solve in sinle line also
        // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void main(String args[]) {
        System.out.println(friendsPairing(3));
    }
}