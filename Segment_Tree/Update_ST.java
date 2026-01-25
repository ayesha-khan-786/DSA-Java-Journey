// Updation on ST
import java.util.*;

public class Update_ST {
    static int tree[];

    public static void initialize(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int i, int start, int end) {     // i => Segment Tree idx
        if(start == end) {                      // leaf node
            tree[i] =  arr[start];
            return arr[start];
        }

        int mid = (start+end) / 2;
        
        buildST(arr, 2*i+1, start, mid);        // left Subtree -> 2*i+1
        buildST(arr, 2*i+2, mid+1, end);        // right Subtree -> 2*i+2

        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if(qj <= si || qi >= sj) {              // case 1 -> non-overlapping 
            return 0;
        }                                       // case 2 -> Complete overlap
        else if(si >= qi && sj <= qj) {
            return tree[i];                     // total value of segment tree(on which present)
        }                                       // case 3 -> Partial overlap
        else {
            int mid = (si + sj) / 2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    // Changes in ST -> O(logn)
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        // case 1 -> idx does not lie in range
        if(idx > sj || idx < si) {
            return;
        }

        // case 2 -> idx lie in ranges
        tree[i] += diff;
        if(si != sj) {      // non-leaf 
            int mid = (si+sj) / 2;
            updateUtil(2*i+1, si, mid, idx, diff);      // left
            updateUtil(2*i+2, mid+1, sj, idx, diff);       // right
        }
    }

    // Updation in arr
    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;      // update idx with new value
    
        updateUtil(0, 0, n-1, idx, diff);
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        initialize(n);
        buildST(arr, 0, 0, n-1);

        System.out.println("Before Updation Sum = " + getSum(arr, 2, 5)); 
        update(arr, 2, 2);
        System.out.println("After Updation Sum = " + getSum(arr, 2, 5)); 
    }
}