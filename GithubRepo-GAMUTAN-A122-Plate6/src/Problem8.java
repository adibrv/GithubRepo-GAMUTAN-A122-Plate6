	/*
	 * GAMUTAN, Adrian C.
	 * BSCS - A122
	 * 
	 * Plate #6
	 * 8. Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.
	 */

import java.util.*;

public class Problem8 {
    public static void main(String[] args) {
        String vertices1 = "A,B,C,D,E,F";
        String edges1 = "AB,BC,CF,FD,DB,BE,ED,EF,AF";
        String vertices2 = "U,V,W,X,Y,Z";
        String edges2 = "UV,VW,WX,XY,YZ,ZU,UX,YV,ZV";

        Graph graph1 = new Graph(vertices1, edges1);
        Graph graph2 = new Graph(vertices2, edges2);

        boolean areIsomorphic = areIsomorphic(graph1, graph2);
        if (areIsomorphic) {
            System.out.println("The graph is isomorphic");
        } else {
            System.out.println("The graph is not isomorphic");
        }
    }

    static class Graph {
        Set<String> vertices = new HashSet<>();
        Map<String, Set<String>> adjList = new HashMap<>();
        int edgeCount = 0;

        Graph(String verticesStr, String edgesStr) {
            for (String v : verticesStr.split(",")) {
                vertices.add(v);
                adjList.put(v, new HashSet<>());
            }
            for (String edge : edgesStr.split(",")) {
                String[] v = edge.split("");
                adjList.get(v[0]).add(v[1]);
                adjList.get(v[1]).add(v[0]);
                edgeCount++;
            }
        }
    }

    public static boolean areIsomorphic(Graph g1, Graph g2) {
        if (g1.vertices.size() != g2.vertices.size() || g1.edgeCount != g2.edgeCount) {
            return false;
        }

        List<String> vertices1 = new ArrayList<>(g1.vertices);
        List<String> vertices2 = new ArrayList<>(g2.vertices);

        return isIsomorphicUtil(g1, g2, vertices1, vertices2, new HashMap<>());
    }

    private static boolean isIsomorphicUtil(Graph g1, Graph g2, List<String> vertices1, List<String> vertices2, Map<String, String> mapping) {
        if (mapping.size() == vertices1.size()) {
            return true;
        }

        String v1 = vertices1.get(mapping.size());

        for (String v2 : vertices2) {
            if (!mapping.containsValue(v2) && isConsistent(g1, g2, v1, v2, mapping)) {
                mapping.put(v1, v2);
                if (isIsomorphicUtil(g1, g2, vertices1, vertices2, mapping)) {
                    return true;
                }
                mapping.remove(v1);
            }
        }
        return false;
    }

    private static boolean isConsistent(Graph g1, Graph g2, String v1, String v2, Map<String, String> mapping) {
        for (String neighbor : g1.adjList.get(v1)) {
            if (mapping.containsKey(neighbor)) {
                String mappedNeighbor = mapping.get(neighbor);
                if (!g2.adjList.get(v2).contains(mappedNeighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
}
