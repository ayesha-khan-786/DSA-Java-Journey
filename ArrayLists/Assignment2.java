// Lonely number in ArrayList
import java.util.*;

public class Assignment2 {
    public static ArrayList<Integer> isLonely( ArrayList<Integer> nums) {
        Collections.sort(nums);             // Sort nums

        ArrayList<Integer> list = new ArrayList<>();        // Define new Arraylist
       
        for(int i=0 ; i<nums.size() ; i++) {
           
            if(( i == 0 || nums.get(i) - nums.get(i-1) > 1) && 
              ( i == nums.size()-1 || nums.get(i+1) - nums.get(i) > 1)) {
               
               list.add(nums.get(i));
              }
        }
        return list;
    }


    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);
        System.out.println(nums);

        System.out.println(isLonely(nums));
    }
}