// Bellman Ford Algorithm
import java.util.*;

public class Bellman_Ford {
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

     static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0 ; i<graph.length ; i++) {
            graph[i] = new ArrayList<>();               
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0 ; i<dist.length ; i++) {
            if(i != src) {                      // if i == src then it is 0
                dist[i] = Integer.MAX_VALUE;    // initialize with +infinity
            }
        }
        int V = graph.length;
        // O(V*E)
        // Step 1 -> Loop 0 to V-1 -> O(V)
        for(int i=0 ; i<V-1 ; i++) {
            // Step 2 -> Calculate all edges - O(E)
            for(int j=0 ; j<graph.length ; j++) {
                for(int k=0 ; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                // Step 3 -> Relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
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
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0);      // o/p -> 0 2 -2 0 4
    }
}