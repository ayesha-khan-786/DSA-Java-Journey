// Creation of ST
import java.util.*;

public class Create_ST {
    static int tree[];

    public static void initialize(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int i, int start, int end) {     // i => Segment Tree idx
        if(start == end) {              // leaf node
            tree[i] =  arr[start];
            return arr[start];
        }

        int mid = (start+end) / 2;
        
        buildST(arr, 2*i+1, start, mid);      // left Subtree -> 2*i+1
        buildST(arr, 2*i+2, mid+1, end);      // right Subtree -> 2*i+2

        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        initialize(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0 ; i<tree.length ; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}