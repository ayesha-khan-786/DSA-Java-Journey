// Two Sum
import java.util.*;

public class Q2 {

    public int[] twoSum(int arr[], int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for(int i=0 ; i<arr.length ; i++) {
            int diff = target - arr[i];     // given target- no at idx i

            // check if found difference is present in map list
            if(visited.containsKey(diff)) {

                //if difference in map matches withthe ith index element in array
                return new int[] {i, visited.get(diff)};        
            }

            //add arr element in map to match withfuture element if forms a pair
            visited.put(arr[i], i);

        }

        //if no matches are found
        return new int[] {0, 0};
    }

    public static void main(String args[]) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

        Q2 obj = new Q2();
        int[] result = obj.twoSum(arr, target);

        System.out.println(Arrays.toString(result));
    }
}