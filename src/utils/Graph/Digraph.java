package utils.Graph;

import java.util.HashSet;
import java.util.Hashtable;

public class Digraph {
    private final int V;
    private final Hashtable<String, HashSet<String>> adj;

    public Digraph(int V) {
        this.V = V;
        adj = new Hashtable<>();
    }

    public void addEdge(String v, String w) {
        adj.get(v).add(w);
    }

    public Iterable<String> adj(String v) {
        return adj.get(v);
    }
}
