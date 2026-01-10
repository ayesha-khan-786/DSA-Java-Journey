// Mother Vertex 
import java.util.*;

public class Q1 {

// Solution 1 -> O(V*(V+E))
    public static int findMotherVer(int V, ArrayList<ArrayList<Integer>> adj) {
        for(int i=0 ; i<V ; i++) {
            boolean[] vis = new boolean[V];
            Queue<Integer> q = new LinkedList<>();

            vis[i] = true;
            q.add(i);
            int count = 1;

            while(!q.isEmpty()) {
                int node = q.poll();

                for(int neighbor : adj.get(node)) {
                    if(!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.add(neighbor);
                        count++;
                    }
                }
            }

            if(count == V) {
                return i;       // i-> mother vertex
            }
        }

        return -1;
    }

// Solution 2 - O(V+E) | SC -> O(V)
    public static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for(int v : adj.get(u)) {
            if(!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
    
    public static int motherVer(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int v= -1;      // candiate through which v vl traverse all vertices

    // STep 1 -> Find candidate i.e last finishedvertex aft dfs
        for(int i=0 ; i<V ; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                v = i;
            }
        }

    // Check if candiate is mother vertex or not
        visited = new boolean[V];        // reset visited
        dfs(v, adj, visited);

        for (boolean vis : visited) {
            if(!vis) {
                return -1;
            }
        }
        return v;
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(4).add(1);
        adj.get(6).add(4);
        adj.get(5).add(6);
        adj.get(5).add(2);
        adj.get(6).add(0);


    System.out.println("Mother vertex is : " + findMotherVer(V, adj));      // 5
    System.out.println("Mother vertex is : " + motherVer(V, adj)); 
    }
}