import java.util.*;

public class IndianCoin {
    
    public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

    // Step 1 - Sort array in dec order
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins  = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

    // Step 2 - add coins to b used to pay amount money
       for(int i=0 ; i<coins.length ; i++) {
            if(coins[i] <= amount) {
                while(coins[i] <= amount) {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total (min) coins used = " + countOfCoins);

    // Print coins used
        for(int i=0 ; i<ans.size() ; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}