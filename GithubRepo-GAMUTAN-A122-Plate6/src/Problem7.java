	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * 7. Write a java program that accepts vertex pairs associated to the edges of an undirected graph 
	 * and the number of times each edge appears. The program should construct an incidence matrix for the graph.
	 */


import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        String input = "121,231,341,411";
        List<Edge> edges = parseEdges(input);
        int numVertices = determineNumVertices(edges);
        int[][] incidenceMatrix = createIncidenceMatrix(edges, numVertices);
        displayIncidenceMatrix(incidenceMatrix);
    }
    
    static class Edge {
        int from;
        int to;
        int multiplicity;
        
        Edge(int from, int to, int multiplicity) {
            this.from = from;
            this.to = to;
            this.multiplicity = multiplicity;
        }
    }
    
    private static List<Edge> parseEdges(String input) {
        List<Edge> edges = new ArrayList<>();
        String[] edgeStrings = input.split(",");
        
        for (String edgeString : edgeStrings) {
            int from = Character.getNumericValue(edgeString.charAt(0));
            int to = Character.getNumericValue(edgeString.charAt(1));
            int multiplicity = Character.getNumericValue(edgeString.charAt(2));
            
            edges.add(new Edge(from, to, multiplicity));
        }
        
        return edges;
    }
    
    private static int determineNumVertices(List<Edge> edges) {
        Set<Integer> vertices = new HashSet<>();
        
        for (Edge edge : edges) {
            vertices.add(edge.from);
            vertices.add(edge.to);
        }
        
        return vertices.size();
    }
    
    private static int[][] createIncidenceMatrix(List<Edge> edges, int numVertices) {
        int numEdges = edges.size();
        int[][] incidenceMatrix = new int[numVertices][numEdges];
        
        for (int j = 0; j < numEdges; j++) {
            Edge edge = edges.get(j);
            incidenceMatrix[edge.from - 1][j] = edge.multiplicity;
            incidenceMatrix[edge.to - 1][j] = edge.multiplicity;
        }
        
        return incidenceMatrix;
    }
    
    private static void displayIncidenceMatrix(int[][] incidenceMatrix) {
        for (int i = 0; i < incidenceMatrix.length; i++) {
            for (int j = 0; j < incidenceMatrix[i].length; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
