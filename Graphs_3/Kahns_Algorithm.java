// Topological Sort Using BFS
import java.util.*;

public class Kahns_Algorithm {

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

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    // Function to calculate indegree
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for(int i=0 ; i<graph.length ; i++) {
            int v = i;
            for(int j=0 ; j<graph[v].size() ; j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
    // step 1 -> Calculate indegree for each node
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

    // Step 2 -> if indegree = 0 add in Q
        for(int i=0 ; i<indeg.length ; i++) {   
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

    // Step 3 -> Perform BFS -> until q is empty, remove curr and print it
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");       // print topological sort

        // indegree-- for curr neighbours
         for(int i=0 ; i<graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            indeg[e.dest]--;

        // After neighbours indegree--, if indegree[neigh] == 0 add in Q
            if(indeg[e.dest] == 0) {
                q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
   
    public static void main(String args[]) {
    
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];    

        CreateGraph(graph);
    
        topSort(graph);    // 4 5 0 2 3 1
    }
}

