// Cheapest Flights with K stops
import java.util.*;

public class Cheapest_Flights {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0 ; i<graph.length ; i++) {       // create empty arraylist
            graph[i] = new ArrayList<>();
        }

    // traverse a flight and wherever edge exist create a edge
        for(int i=0 ; i<flights.length ; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);          // Add edge in graph at src idx
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        // Initialize distance
        int dist[] = new int[n];
        for(int i=0 ; i<n ; i++) {
            if(i != src) {      // if src = i -> dist = 0
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {       
                break;
            }

            // Update curr neighbour
            for(int i=0 ; i<graph[curr.v].size() ; i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

            // Relaxation step
                if(curr.cost + wt < dist[v] && curr.stops <= k) {         //dist[u] != Integer.MAX_VALUE -> in java if anything add in infinity, value becomes -ve
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        // Dist[dest]
        if(dist[dest] == Integer.MAX_VALUE) {       // can't reach dest
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void main(String args[]) {
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};        // flights[i] = [from, to, price]
        int src = 0, dest = 3, k = 1;

       System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}