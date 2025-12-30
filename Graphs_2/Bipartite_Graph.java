import java.util.*;

public class BFS {

    static class Edge {
        int src;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
        int dest;
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0 ; i<graph.length ; i++) {
            graph[i] = new ArrayList<>();               
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
    //    graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
    //    graph[4].add(new Edge(4, 3));
    }

    // O(V+E)
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for(int i=0 ; i<color.length ; i++) {
            color[i] = -1;      // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<graph.length ; i++) {
            if(color[i] == -1) {        // Perform BFS
                q.add(i);
                color[i] = 0;       // yellow
                
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0 ; j<graph[curr].size(); j++) {      // check for neighbour
                        Edge e = graph[curr].get(j);        // e.dest

                        // case 1 -> no color
                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }
                        // case 2 -> node with same color -> Not Bipartite
                        else if(color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        /* If graph doesn't have cycle -> BIPARTITE
                0 -------- 2
               /          /
              /          /
             1          4
              \        /
               \      /
                  3
                  FALSE
         */
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];    

        CreateGraph(graph);
        
        System.out.println(isBipartite(graph));     // false 
        System.out.println(isBipartite(graph));     // True -> if comment out node 3,4
    }
}

