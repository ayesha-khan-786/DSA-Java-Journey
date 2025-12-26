import java.util.*;

public class Create_Graph {

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

    public static void main(String args[]) {
        /* () -> weight , (0,1,2,3,4) -> vertex
                                (5)
                            0 -------- 1
                                      /  \
                                (1)  /    \ (3)
                                    /      \
                                   2 ------ 3
                                   |  (1)
                                (2)| 
                                   |
                                   4
         */
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];     // int arr[] = new arr[V];

        // null -> empty arrayList
        for(int i=0 ; i<V ; i++) {
            graph[i] = new ArrayList<>();               // create ArrayList to store edges
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

        // Store neighbour of vertex 2
        for(int i=0 ; i<graph[2].size() ; i++) {
            Edge e = graph[2].get(i);  
            System.out.println(e.dest); 
        }
    }
}