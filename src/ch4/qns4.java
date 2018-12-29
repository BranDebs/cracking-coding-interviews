package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Check Balanced
 * Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns4 {

    private static BinaryTreeNode<Integer> getTreeSize(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<Integer> left = getTreeSize(node.left);
        BinaryTreeNode<Integer> right = getTreeSize(node.right);
        int count = 0;
        if (left != null) {
            count += left.value;
        }
        if (right != null) {
            count += right.value;
        }
        count += 1;
        return new BinaryTreeNode<>(count, left, right);
    }
    private static boolean isBalanced(BinaryTree<Integer> tree) {
        BinaryTreeNode<Integer> sizeTreeRoot = getTreeSize(tree.getRoot());
        return isBalanced(sizeTreeRoot);
    }

    private static boolean isBalanced(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return false;
        }
        int leftCount = (int) node.left.value;
        int rightCount = (int) node.right.value;
        int diff = Math.abs(leftCount - rightCount);
        return diff <= 1;
    }

    public static void run() {
        BinaryTree<Integer> balanced = genBalancedTree();
        printOutput(balanced);
        BinaryTree<Integer> unbalanced = genUnbalancedTree();
        printOutput(unbalanced);
    }

    private static void printOutput(BinaryTree<Integer> tree) {
        System.out.print("Given a balanced tree represented inorder ");
        System.out.print(tree.getInOrder() + " is it balanced?: ");
        System.out.println(isBalanced(tree));
    }

    private static BinaryTree<Integer> genBalancedTree() {
        int[] balanced = {1,2,3,4,5,6,7};
        return ch4.qns2.getMinimalTree(balanced);
    }

    private static BinaryTree<Integer> genUnbalancedTree() {
        BinaryTreeNode<Integer> root;
        BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(2,
                new BinaryTreeNode<>(1, null, null),
                new BinaryTreeNode<>(3, null, null));
        BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(6, null, null);
        root = new BinaryTreeNode<Integer>(4, left, right);
        return new BinaryTree<Integer>(root);
    }
}
