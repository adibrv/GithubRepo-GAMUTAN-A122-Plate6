	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 3. Write a java program that will determine if a graph has a cycle or not.
	 */

public class Problem3 {
	
    public static boolean dfs(int v, int parent, boolean[] visited, int[][] adjacencyMatrix) {
        visited[v] = true;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                if (!visited[i]) {
                    if (dfs(i, v, visited, adjacencyMatrix))
                        return true;
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleCheck(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adjacencyMatrix))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        if (cycleCheck(adjacencyMatrix)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
}

