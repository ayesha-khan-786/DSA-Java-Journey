import java.util.*;

public class dfs_hepler {

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

    // DFS Helper
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {       // O(V+E)
        // visit curr
        System.out.print(curr + " ");
        vis[curr] = true;

        // Call for neighbours
        for(int i=0 ; i<graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {                    // if neighbour is not visited then visit it
                dfsUtil(graph, e.dest, vis);        // e.dest = neighbour value
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
        dfs(graph, 0, new boolean[V]);                  // o/p -> 0 1 3 4 2 5 6
        
    }
}

