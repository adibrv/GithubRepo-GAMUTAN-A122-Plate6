	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 6. Write a java program that receives the vertex pairs 
	 * associated to the edges of a graph, the program should construct an 
	 * adjacency matrix for the graph. 
	 * (Produce a version that works when loops, multiple edges, or directed edges are present.)
	 */


import java.util.*; // Scanner, List, ArrayList, Map, HashMap

public class Problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in your graph: ");
        int verticesNum = scanner.nextInt();
        scanner.nextLine();

        List<String> vertexList = new ArrayList<>();
        for (int i = 0; i < verticesNum; i++) {
            System.out.print("Enter vertex " + (i + 1) + ": ");
            vertexList.add(scanner.nextLine());
        }

        System.out.print("Enter the number of edges in your graph: ");
        int edgesNum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter edges in the format 'v1 v2':");
        int[][] adjacencyMatrix = new int[verticesNum][verticesNum];
        Map<String, Integer> vertexIndexMap = new HashMap<>();

        for (int i = 0; i < verticesNum; i++) {
            vertexIndexMap.put(vertexList.get(i), i);
        }

        for (int i = 0; i < edgesNum; i++) {
            System.out.print("Edge (" + (i + 1) + "): ");
            String edge = scanner.nextLine();
            String[] vertices = edge.split(" ");
            String v1 = vertices[0];
            String v2 = vertices[1];
            int index1 = vertexIndexMap.get(v1);
            int index2 = vertexIndexMap.get(v2);

            adjacencyMatrix[index1][index2]++;
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < verticesNum; i++) {
            for (int j = 0; j < verticesNum; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
