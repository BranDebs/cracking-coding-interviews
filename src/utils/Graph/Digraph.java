package utils.Graph;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Digraph where the both the key and value pair have a value of String.
 */
public class Digraph {
    private final int V;
    private final Hashtable<String, HashSet<String>> adj;

    public Digraph(int V) {
        this.V = V;
        adj = new Hashtable<>();
    }

    public void addEdge(String v, String w) {
        if (!adj.containsKey(v)) {
            HashSet<String> neighbours = new HashSet<>();
            if (w != null) {
                neighbours.add(w);
            }
            adj.put(v, neighbours);
            return;
        }
        adj.get(v).add(w);
    }

    public Iterable<String> adj(String v) {
        if (!adj.containsKey(v)) {
            return null;
        }
        return adj.get(v);
    }

    public Iterable<String> getNodes() {
        return adj.keySet();
    }
}
