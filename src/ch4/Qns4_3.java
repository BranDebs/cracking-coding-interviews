package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

import java.util.*;


public class Qns4_3 {
  private static List<LinkedList<Integer>> listOfDepths(BinaryTreeNode<Integer> root) {
    if (root == null) {
      return null;
    }
    List<LinkedList<Integer>> out = new ArrayList<>();
    bfs(root, out);
    return out;
  }

  private static void bfs(BinaryTreeNode<Integer> root, List<LinkedList<Integer>> out) {
    Deque<BinaryTreeNode<Integer>> q = new LinkedList<>();
    q.addLast(root);
    int prevCnt = 1, curCount = 0;
    LinkedList<Integer> l = new LinkedList<>();
    while(!q.isEmpty()) {
      BinaryTreeNode<Integer> cur = q.pop();
      curCount++;
      l.add(cur.value);
      if (cur.left != null) {
        q.offer(cur.left);
      }
      if (cur.right != null) {
        q.offer(cur.right);
      }
      if (curCount == prevCnt) {
        prevCnt = q.size();
        curCount = 0;
        out.add(l);
        l = new LinkedList<>();
      }
    }
  }

  public static void tests() {
    //  1
    // 2 3
    BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1, new BinaryTreeNode<>(2,null,null), new BinaryTreeNode<>(3,null, null));
    printHelper(listOfDepths(root1));

    //  1
    // 2 3
    //4 5
    // 6 7
  }

  private static void printHelper(List<LinkedList<Integer>> list) {
    for (LinkedList<Integer> ll : list) {
      StringJoiner sj = new StringJoiner("=>", "[", "]");
      for (int i : ll) {
        sj.add(Integer.toString(i));
      }
      System.out.println(sj.toString());
    }
  }
}
