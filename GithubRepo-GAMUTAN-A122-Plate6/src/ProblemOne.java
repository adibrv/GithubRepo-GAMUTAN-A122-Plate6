	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * Problem 1. Write a java program that receives a list of edges of a simple graph, 
	 * the program should determine whether it is connected and find the number of 
	 * connected components if it is not connected.
	 */


import java.util.*; //Scanner, List, ArrayList, Set, HashSet, Map, HashMap

public class ProblemOne {

    // Depth-first Search Function
	private static void dfs(String vertex, Set<String> visited, Map<String, List<String>> adjacencyList) {
        visited.add(vertex);
        for (String neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, adjacencyList);
            }
        }
    }

	// Connectivity function
    private static boolean isConnected(List<String> vertices, Map<String, List<String>> adjacencyList) {
        if (vertices.isEmpty()) {
            return true;
        }

        Set<String> visited = new HashSet<>();
        String startVertex = vertices.get(0);
        dfs(startVertex, visited, adjacencyList);

        // If all vertices are visited in the search, the graph is connected
        return visited.size() == vertices.size();
    }

    // Count number of subgraphs if graph is not connected
    private static int countConnectedComponents(List<String> vertices, Map<String, List<String>> adjacencyList) {
        Set<String> visited = new HashSet<>();
        int components = 0;

        for (String vertex : vertices) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, adjacencyList);
                components++;
            }
        }

        return components;
    }

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

        // Initialize adjacent vertex list
        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String vertex : vertexList) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        // List adjacent edges of each vertex
        for (String edge : edgeList) {
            String[] vertices = edge.split(" ");
            String v1 = vertices[0];
            String v2 = vertices[1];
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        }

        // Determine graph connectivity
        boolean connected = isConnected(vertexList, adjacencyList);
        if (connected) {
            System.out.println("The graph is connected.");
        } else {
            int components = countConnectedComponents(vertexList, adjacencyList);
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + components);
        }

        scanner.close();
    }
}
