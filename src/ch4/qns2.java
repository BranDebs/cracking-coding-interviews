package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Minimal Tree
 * Given a sorted (increasing order) array with unique integer elements, write an algo-
 * rithm to create a binary search tree with minimal height.
 *
 * Time:
 * Space:
 */
public class qns2 {

    public static BinaryTree<Integer> getMinimalTree(int[] arr) {
        BinaryTree<Integer> minTree = null;

        if (arr.length < 1) {
            return null;
        }

        if (arr.length == 1) {
            return new BinaryTree<>(new BinaryTreeNode<>(arr[0],null,null));
        }

        // TODO code out the entire algorithm.

        return minTree;
    }

    public static void run() {

    }
}
