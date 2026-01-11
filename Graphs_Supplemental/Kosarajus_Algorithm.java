// Strongly Cpnnected Component -> O(V+E)
import java.util.*;

public class Kosarajus_Algorithm {

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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0 ; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0 ; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        // Step 1 -> Get nodes in stack (Topological Sort)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0 ; i<V; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // Step 2 -> Transpose the graph (reverse the edges)
        ArrayList<Edge> transpose[] = new ArrayList[V];  
        for(int i=0 ; i<graph.length ; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();               
        }

        for(int i=0 ; i<V ; i++) {
            for(int j=0 ; j<graph[i].size(); i++) {
                Edge e = graph[i].get(j);       // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src));  // e.dest -> e.src
            }
        }

        // Step 3 -> Do DFS on transpose graph
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC : ");
                dfs(transpose, curr, vis);      // Print scc
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
       
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];     

        CreateGraph(graph);
        kosaraju(graph, V);
    }
}

