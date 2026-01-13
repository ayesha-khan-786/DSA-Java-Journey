// Articulation Point -> O(V+E)
import java.util.*;

public class Articulation_Pt {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0 ; i<graph.length ; i++) {
            graph[i] = new ArrayList<>();               
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, 
                            int dt[], int low[], int time, boolean vis[], boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0 ; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

            // AP condition 2
                if(par != -1 && dt[curr] <= low[neigh]) {
                    //System.out.println("Ap : " + curr);     // 3
                    ap[curr] = true;
                }
                children++;
            }
        }

            // AP condition 1
            if(par == -1 && children > 1) {
                //System.out.print("Ap : " + curr);           // 0
                ap[curr] = true;
            }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];      // track Ap

        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }

        // Print all AP's
         for(int i=0 ; i<V ; i++) {
            if(ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String args[]) {
       
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];     

        CreateGraph(graph);
        getAP(graph, V);
    }
}

