// Q1 -> Detect cycle in an undirected graph using BFS
import java.util.*;

public class Detect_Cycle_BFS {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
         for(int i=0 ; i<graph.length ; i++) {
            graph[i] = new ArrayList<>();               
        }

        graph[9].add(new Edge(9, 5));
        graph[9].add(new Edge(9, 1));

        graph[5].add(new Edge(5, 9));
        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));

        graph[1].add(new Edge(1, 9));
        graph[1].add(new Edge(1, 5));

        graph[2].add(new Edge(2, 5));
        graph[2].add(new Edge(2, 4));

        graph[4].add(new Edge(4, 2));        
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        int parent[] = new int[graph.length];
        Arrays.fill(parent, -1);        // Initially -1 means no parent

        for(int i=0 ; i<graph.length ; i++) {
            if(!vis[i]) {
                if(bfs(graph, vis, parent, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfs(ArrayList<Edge> graph[], boolean vis[], int parent[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();

            for(int i=0 ; i<graph[curr].size(); i++) {
                 Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                vis[e.dest] = true;
                parent[e.dest] = curr;
                q.add(e.dest);
            }
             else if(e.dest != parent[curr]) {
                return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        /*
                9 -- 5 -- 2
                |  /      |
                | /       |
                |/        |
                1         4
        */
         int V = 10;
        ArrayList<Edge> graph[] = new ArrayList[V];    

        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}