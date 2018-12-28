package ch4;

import utils.Graph.Digraph;

import java.util.HashSet;

class Dfs {
    private Digraph G;
    private HashSet<String> visited;

    public Dfs(Digraph G) {
        this.G = G;
        visited = new HashSet<String>();
    }

    public boolean hasPath(String src, String dst) {
        if (G.adj(src) == null) {
            return false;
        }
        visited.add(src);
        for (String neighbour : G.adj(src)) {
            if (neighbour.equals(dst)) {
                return true;
            } else if (!visited.contains(neighbour)) {
                if (hasPath(neighbour, dst)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Route Between Nodes
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 *
 * Time: O(V)
 * Space: O(V)
 */
public class qns1 {

    private static Digraph initConnectedGraph() {
        Digraph connected = new Digraph(5);
        connected.addEdge("A", "B");
        connected.addEdge("A", "C");
        connected.addEdge("B", "D");
        connected.addEdge("C", "D");
        connected.addEdge("B", "E");
        return connected;
    }

    private static Digraph initUnconnectedGraph() {
        Digraph unconnected = new Digraph(5);
        unconnected.addEdge("A", "B");
        unconnected.addEdge("A", "C");
        unconnected.addEdge("B", "D");
        unconnected.addEdge("C", "D");
        unconnected.addEdge("E", "E");
        return unconnected;
    }

    public static void run() {
        Digraph connected = initConnectedGraph();
        Dfs connectedDfs = new Dfs(connected);
        System.out.println("Given a connected graph");
        System.out.println("Is A connected to E?: " + connectedDfs.hasPath("A", "E"));

        Digraph unconnected = initUnconnectedGraph();
        Dfs unconnectedDfs = new Dfs(unconnected);
        System.out.println("Given an unconnected graph");
        System.out.println("Is A connected to E?: " + unconnectedDfs.hasPath("A", "E"));
    }
}
