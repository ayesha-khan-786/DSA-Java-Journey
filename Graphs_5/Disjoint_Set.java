// Disjoint Set DS
import java.util.*;

public class Disjoint_Set {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        // initialize Parent -> All are self parent 
        for(int i=0 ; i<n ; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);        // Recursively call parent of parent
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String args[]) {
        init();
        union(1, 3);
        System.out.println(find(3));        // 1 is leader

        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));        // 1
        System.out.println(find(4));        // 1

        union(1, 5);
    }
}