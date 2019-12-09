package ch4;

import utils.Tree.*;

public class qns4_2 {
  private static BinaryTreeNode<Integer> MinimalTree(int[] nodesVal) {
    int left = 0;
    int right = nodesVal.length - 1;
    BinaryTreeNode<Integer> node = recurse(nodesVal, left, right);
    return node;
  }

  private static BinaryTreeNode<Integer> recurse(int[] nodesVal, int left, int right) {
    if (right == left) {
      return new BinaryTreeNode<Integer>(nodesVal[left], null, null);
    }
    if (left < right) {
      int mid = (left + right)/2;
      BinaryTreeNode<Integer> leftNode = recurse(nodesVal, left, mid-1);
      BinaryTreeNode<Integer> rightNode = recurse(nodesVal, mid+1, right);
      return new BinaryTreeNode<Integer>(nodesVal[mid], leftNode, rightNode);
    }
    return null;
  }

  public static void tests() {
    int[] test1 = {1,2,3,4,5,6,7,8,9};
    int[] test2 = {1,2,3,4,5};
    int[] test3 = {1,2};
    BinaryTree<Integer> bt = new BinaryTree<>(MinimalTree(test1));
    System.out.println(bt.getInOrder());
    BinaryTree<Integer> bt2 = new BinaryTree<>(MinimalTree(test2));
    System.out.println(bt2.getInOrder());
    BinaryTree<Integer> bt3 = new BinaryTree<>(MinimalTree(test3));
    System.out.println(bt3.getInOrder());
  }
}
