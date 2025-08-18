public class RatMaze {

    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length && y >=0 && y< maze.length && maze[x][y] == 1);    // maxe[x][y] == 1 is open path
    }

    public static void solveMaze(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];

        if(solveMazeUtil(maze, 0, 0, sol)) {        // start solving maze from 0,0
            printSol(sol);
        } else {
            System.out.println("No path found");
        }
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        int n = maze.length;
        // Base Case
        if( x == n-1 && y == n-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;                // Path found
        }

        // check if x, y is safe
        if(isSafe(maze, x, y)) {
            sol[x][y] = 1;

        // Right
            if(solveMazeUtil(maze, x, y+1, sol))
            return true;

        // Down 
            if(solveMazeUtil(maze, x+1, y, sol))
            return true;
        
        // if both fail backtrack
        sol[x][y] = 0;
        return false;
        }
       
        return false;
    }

    public static void printSol(int sol[][]) {
        for(int i=0 ; i<sol.length ; i++) {
            for(int j=0 ; j<sol.length ; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}