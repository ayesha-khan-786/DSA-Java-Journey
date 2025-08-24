// Most Frequent Number following key (#Leetcode - 2190)

import java.util.*;

public class Assignment3 {
    
    public static int mostFrequency(ArrayList<Integer> nums, int key) {
        int ans = 0;                 // most frquent number
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>(); 

    // Collect number after key i.e target
        for(int i=0 ; i<nums.size()-1 ; i++) {
            if(nums.get(i) == key) {
                 int target = nums.get(i+1);
                 list.add(target);
                }
            }

    // Count frquency 
        for(int i=0 ; i<list.size() ; i++) {
            int count = 0;
            for(int j=0 ; j<list.size() ; j++) {
                 if(list.get(j).equals(list.get(i))) {
                    count++;
            }
            }
           if(count > max) {
                max = count;
                ans = list.get(i);
           }
        } 
         return ans;
        }


    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(3);

        System.out.println(nums);
        int key = 2;

        System.out.println(mostFrequency(nums, key));
    }
}