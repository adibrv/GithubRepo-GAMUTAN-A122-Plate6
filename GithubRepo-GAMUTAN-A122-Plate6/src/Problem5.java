	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 5. Write a java program that receives a list of edges of a simple graph 
	 * and determine whether the graph is bipartite.
	 */

import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
        		{0, 1, 0, 1},
        		{1, 0, 0, 1},
        		{0, 0, 0, 0},
        		{1, 1, 0, 0}

        };

        System.out.println("The graph is " + (isBipartite(adjacencyMatrix) ? "bipartite" : "not bipartite"));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!bfsCheck(graph, i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor = 0; neighbor < graph[node].length; neighbor++) {
                if (graph[node][neighbor] > 0) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[node];
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
