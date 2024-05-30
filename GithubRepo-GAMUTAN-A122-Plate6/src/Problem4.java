	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 4. Write a java program, given the pair of vertex associated to the edges of an undirected graph, 
	 * it will output the degree of vertex.
	 */


import java.util.*;

public class Problem4 {

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
        List<String> edgeList = new ArrayList<>();
        for (int i = 0; i < edgesNum; i++) {
            System.out.print("Enter edge (" + (i + 1) + ") in format 'v1 v2': ");
            edgeList.add(scanner.nextLine());
        }

        System.out.println("Vertex list: " + vertexList);
        System.out.println("Edges list: " + edgeList);

        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String vertex : vertexList) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        for (String edge : edgeList) {
            String[] vertices = edge.split(" ");
            String v1 = vertices[0];
            String v2 = vertices[1];
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        }
        
        System.out.println("Degrees of vertices:");
        for (String vertex : vertexList) {
            System.out.println("deg(" + vertex + ") = " + adjacencyList.get(vertex).size());
        }

        scanner.close();
    }
}
