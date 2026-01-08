// Kruskal's Algorithm
import java.util.*;

public class Kruskals_Algorithm {
   
   // Step 1 -> Create class for edges
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
  
        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;     
        }
    }
         
    // Step 2 -> Create Graph
    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Step 3 -> Union Code 
        static int n = 4;       // vertices number
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

    // Step 4 -> Kruskal's Algorithm
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        // Sort edges
        Collections.sort(edges);    // O(ElogE)
        int mstCost = 0;     // ans
        int count = 0;      // in MST how many edges included
   
        for(int i=0 ; count<V-1 ; i++) {        // i<edges.length -> this takes more time
            Edge e = edges.get(i);

            // Detect cycle
            int parA = find(e.src);     // src = A
            int parB = find(e.dest);    // dest = B

            if(parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);        // 55
    }

    public static void main(String args[]) {
       int V = 4;
       ArrayList<Edge> edges = new ArrayList<>();
       createGraph(edges);

       kruskalsMST(edges, V);
    }
}