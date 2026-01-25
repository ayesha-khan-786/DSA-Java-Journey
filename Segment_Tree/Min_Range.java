// Find Min in given qeries
import java.util.*;

public class Min_Range {
    static int tree[];

    public static void initialize(int n) {
        tree = new int[4*n];
    }

    public static void buildTree(int i, int si, int sj, int arr[]) {
        if(si == sj) {
            tree[i] = arr[si];          // leaf node
            return;
        }

        int mid = (si+sj)/2;
        buildTree(2*i+1, si, mid, arr);
        buildTree(2*i+2, mid+1, sj, arr);

        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);           
    }

    public static int getMin(int arr[], int qi, int qj) {      
        int n = arr.length;
        return getMinUtil(0, 0, n-1, qi, qj);
    }

    public static int getMinUtil(int i, int si, int sj, int qi, int qj) {
        if(si > qj || sj < qi) {                                 // case 1 -> No overlap
            return Integer.MAX_VALUE;               
        } else if(si >= qi && sj <= qj) {                        // case 2 -> Complete overlap
            return tree[i];
        } else {                                                 // case 3 -> Partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMinUtil(2*i+1, si, mid, qi, qj);
            int rightAns = getMinUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.min(leftAns, rightAns);             
        }       
    }

    // Array updation
    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    // Segment Tree Updation
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if(idx < si || idx > sj) {                              // case 1 -> Non overlap
            return; 
        }

        if(si == sj) {                                          // leaf 
            tree[i] = newVal;
        }              
        if(si != sj) {                                           // case 2 -> Overlap
            tree[i] = Math.min(tree[i], newVal);                 // non-leaf
            int mid = (si + sj) / 2;
            updateUtil(2*i+1, si, mid, idx, newVal);            // Update left Subtree
            updateUtil(2*i+2, mid+1, sj, idx, newVal);          // Update right Subtree
        }
        
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        initialize(n);
        buildTree(0, 0, n-1, arr);

        int min = getMin(arr, 2, 5);
        System.out.println(min);        // -1

        update(arr, 2, 20);

        min = getMin(arr, 2, 5);
        System.out.println(min);        // 1
    }
}