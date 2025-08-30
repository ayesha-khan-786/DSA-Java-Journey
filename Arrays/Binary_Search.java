import java.util.*;

public class Binary_Search {

    public static int binarySearch(int nums[], int key) {
        int start = 0;
        int end = nums.length-1;

    while(start <= end) {
        int mid = (start + end) / 2;

        if(nums[mid] == key) {
            return mid;
        } 
        else if(key < nums[mid]) {
            end = mid - 1;
        } 
        else {
            start = mid + 1;
        }
    }
        return -1;
        
    }

    public static void main(String args[]) {
        int nums[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;
        int result = binarySearch(nums, key);
        System.out.println("Key is found at index " + result);
    }
}