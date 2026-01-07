// Bellman Ford Algorithm
import java.util.*;

public class Bellman_Optimized {
        static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

     static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for(int i=0 ; i<dist.length ; i++) {
            if(i != src) {                      // if i == src then it is 0
                dist[i] = Integer.MAX_VALUE;    // initialize with +infinity
            }
        }
    
    // O(VE)
        // Step 1 -> Loop 0 to V-1 -> O(V)
        for(int i=0 ; i<V-1 ; i++) {
            // Step 2 -> Calculate all edges - O(E)
            for(int j=0 ; j<graph.size() ; j++) {
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                // Step 3 -> Relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }

        // Print shortest distances
        for(int i=0 ; i<dist.length ; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);

        bellmanFord(graph, 0, V);      // o/p -> 0 2 -2 0 4
    }
}