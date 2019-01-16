package ch4;

import utils.Graph.Digraph;

import java.util.HashSet;

/**
 * Build Order
 * You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns7 {

    private static void getBuildOrder(Digraph g, String node, StringBuilder sb, HashSet<String> visited) {
        if (!visited.contains(node)) {
            visited.add(node);
        } else {
            sb = new StringBuilder();
            return;
        }

        if (g.adj(node) == null) {
            sb.append(node);
            return;
        }

        for (String n: g.adj(node)) {
            if (visited.contains(n)) {
                continue;
            }
            getBuildOrder(g, n, sb, visited);
        }
        sb.append(node);
    }

    private static boolean hasCycles(Digraph g,String node, HashSet<String> visited) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        if (g.adj(node) == null) {
            return false;
        }
        for (String n : g.adj(node)) {
            if (hasCycles(g, n, visited)) {
                return true;
            }
        }
        return false;
    }

    private static String getBuildOrder(Digraph g) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> visited = new HashSet<>();
        for (String node : g.getNodes()) {
            getBuildOrder(g, node, sb, visited);
        }
        sb = sb.reverse();
        int idx = 0;
        String src = Character.toString(sb.charAt(idx));

        while (g.adj(src) == null && idx < (sb.length())) {
            idx++;
            src = Character.toString(sb.charAt(idx));
        }

        if (idx >= sb.length()) {
            return sb.toString();
        }

        if (hasCycles(g, src, new HashSet<>())) {
            return "Error";
        }

        return sb.toString();
    }

    private static Digraph initGraph1() {
        Digraph g = new Digraph(6);
        g.addEdge("a", "d");
        g.addEdge("f", "b");
        g.addEdge("b", "d");
        g.addEdge("f", "a");
        g.addEdge("d", "c");
        g.addEdge("e", null);
        return g;
    }

    private static Digraph initGraph2() {
        Digraph g = new Digraph(2);
        g.addEdge("a", "b");
        g.addEdge("b", "a");
        return g;
    }

    public static void run() {
        Digraph g = initGraph1();

        System.out.println("Given the graph a b c d e f with dependencies (a,d) (f,b) (b,d) (f,a) (d,c) the build order is: "
                + getBuildOrder(g));

        g = initGraph2();
        System.out.println("Given the graph a b with dependencies (a,b) (b,a): "
                + getBuildOrder(g));

    }
}
