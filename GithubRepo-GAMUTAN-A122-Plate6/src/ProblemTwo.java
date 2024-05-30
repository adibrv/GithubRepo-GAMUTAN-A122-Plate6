	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 2. Write a java program that accepts an adjacency matrix of a graph. 
	 * The program should list the edges of this graph and give the number of times 
	 * each edge appears.
	 */


import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 5, 0, 7},
            {2, 0, 0, 3},
            {0, 0, 0, 0},
            {8, 4, 0, 0}, 
        };

        List<List<String>> edgesList = new ArrayList<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            List<String> edges = new ArrayList<>();
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edges.add((j + 1) + " (" + adjacencyMatrix[i][j] + " time" + (adjacencyMatrix[i][j] > 1 ? "s" : "") + ")");
                }
            }
            edgesList.add(edges);
        }

        System.out.println("Connected edges:");
        for (int i = 0; i < edgesList.size(); i++) {
            System.out.print((i + 1) + ": ");
            List<String> edges = edgesList.get(i);
            System.out.println(String.join(", ", edges));
        }
    }
}
