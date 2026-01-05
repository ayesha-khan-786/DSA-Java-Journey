// Find the size of largest region in the boolean matrix
import java.util.*;

public class LargestRegion {

    public int findLargestRegion(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxRegion = 0;

    // Iterate through each cell in matrix
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                // if cell = 1 && not visited
                if(matrix[i][j] == 1 && !visited[i][j]) {
                // start DFS from this cell & get curr region size
                    int currRegionSize = dfs(matrix, i, j, visited, rows, cols);
                    maxRegion = Math.max(maxRegion, currRegionSize);
                }
            }
        }

        return maxRegion;
    }

    public int dfs(int[][] matrix, int r, int c, boolean[][] visited, int rows, int cols) {
        if( r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;
        int currRegionSize = 1;

        // Define all 8 neighbours of curr(horizontal -> 2, vertical -> 2, diagonal -> 4)
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};     // row changes
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};     // column changes

        // Recursively call for all 8 adjacent neighbours
        for(int i=0 ; i<8 ; i++) {
            currRegionSize += dfs(matrix, r + dr[i], c + dc[i], visited, rows, cols);
        }

        return currRegionSize;
    }

    public static void main(String args[]) {
        LargestRegion solver = new LargestRegion();

        int[][] matrix = {
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 1}
        };

        System.out.println("Largest region for matrix is " + solver.findLargestRegion(matrix)); // o/p -> 5
    }
}