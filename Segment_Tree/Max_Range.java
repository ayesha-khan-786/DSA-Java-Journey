// Max element in given queries
import java.util.*;

public class Max_Range {
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

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if(si > qj || sj < qi) {                    // case 1 -> No overlap
            return Integer.MIN_VALUE;
        } else if(si >= qi && sj <= qj) {           // case 2 -> Complete overlap
            return tree[i];
        } else {                                    // case 3 -> Partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2*i+1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }   

        
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        initialize(n);
        buildTree(0, 0, n-1, arr);

        //for(int i=0 ; i<tree.length ; i++) {
        //    System.out.print(tree[i] + " ");
        //}

        int max = getMax(arr, 2, 5);
        System.out.println(max);        // 17
    }
}