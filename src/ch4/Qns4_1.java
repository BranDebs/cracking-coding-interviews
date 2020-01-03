package ch4;

import utils.Graph.Digraph;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Qns4_1 {
  private static boolean RouteBetweenNodes(Digraph G, String src, String dst) {
    if (G == null || src == null || dst == null) {
      return false;
    }

    Deque<String> bfs = new LinkedList<>();
    bfs.offerLast(src);
    while (bfs.size() != 0) {
      String curNode = bfs.poll();
      if (curNode.equals(dst)) {
        return true;
      }
      Iterable<String> adjNodes = G.adj(curNode);
      if (adjNodes != null) {
        for (String node : adjNodes) {
          bfs.offerLast(node);
        }
      }
    }
    return false;
  }

  public static void tests() {
    Digraph emptyG = new Digraph(0);
    System.out.printf("Empty graph path %b\n", RouteBetweenNodes(emptyG, "A", "Z"));

    Digraph notConnGraph = new Digraph(5);
    notConnGraph.addEdge("A", "B");
    notConnGraph.addEdge("A", "C");
    notConnGraph.addEdge("Y", "Z");
    System.out.printf("Not connected graph %b\n", RouteBetweenNodes(notConnGraph, "A", "Z"));

    Digraph connGraph = new Digraph(5);
    connGraph.addEdge("A", "B");
    connGraph.addEdge("A", "C");
    connGraph.addEdge("Y", "Z");
    connGraph.addEdge("C", "Z");
    System.out.printf("Not connected graph %b\n", RouteBetweenNodes(connGraph, "A", "Z"));
  }
}
