import java.util.*;

public class LinearSearch {

    public static int linearSearch(int nums[] , int key) {
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 10;

        int idx = linearSearch(nums, 10);
        if(idx == -1) {
            System.out.println("Key not found!");
        } else {
            System.out.println("Key found at index : " + idx);
        }
    }
}