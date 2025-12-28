import java.util.*;

public class bfs_helper {

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

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0 ; i<graph.length ; i++) {
            graph[i] = new ArrayList<>();               
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];  
        for(int i=0 ; i<graph.length ; i++) {
            if(!vis[i]) {
                bfsUtil(graph, vis);
            }
        }    
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {       // O(V+E)
        Queue<Integer> q = new LinkedList<>();          // To store visited vertex
            
        q.add(0);       // source = 0

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {                                    // If not visit curr then do 3 Steps
                System.out.print(curr + " ");                 // Step 1 -> print
                vis[curr] = true;                               // Step 2 -> mark visit = true
                for(int i=0 ; i<graph[curr].size() ; i++) {     // Step 3 -> add neighbours in Q
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);                              // edge's dest is neighbour
                }
            }
        }

    }

    public static void main(String args[]) {
        /* 
                1 ---- 3
               /       | \
              0        |   5 ---- 6
               \       | /
                2 ---- 4
         */
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];     // int arr[] = new arr[V];

        CreateGraph(graph);
        bfs(graph);     // O/p -> 0 1 2 3 4 5 6 
        
    }
}

