import java.util.*;

public class TrappingRainWater {

    public static int trapWater(int height[]) {
        int n = height.length;
        int left = height[0];
        int right = height[n-1];
        int low = 1;
        int high = n-2;
        int ans = 0;

        while(low <= high) {
            if(left < right) {
                left = Math.max(left, height[low]);
                ans += (left - height[low]);
                low++;
            } else {
                right = Math.max(right, height[high]);
                ans += (right - height[high]);
                high--;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int height[] = {4, 2, 0, 3, 2, 5};
        System.out.println(trapWater(height));
        
    }
}