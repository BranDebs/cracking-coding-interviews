package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * First Common Ancestor
 * Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns8 {

    private static BinaryTreeNode<String> getCommonAncestor(BinaryTree<String> tree, String A, String B) {
        return getCommonAncestor(tree.getRoot(), A, B);
    }

    private static BinaryTreeNode<String> getCommonAncestor(BinaryTreeNode<String> node, String A, String B) {
        if (node == null) {
            return null;
        }
        if (node.value.equals(A) || node.value.equals(B)) {
            return node;
        }
        BinaryTreeNode<String> left = null, right = null;
        left = getCommonAncestor(node.left, A, B);
        right = getCommonAncestor(node.right, A, B);

        if (left != null && right != null) {
            return node;
        }
        if ( left != null) {
            return left;
        }
        return right;
    }

    public static void run() {
        BinaryTree<String> tree = genTree();
        String targetA = "", targetB = "";
        System.out.println("=== Given the tree " + tree.getInOrder() + " ===");

        targetA = "E"; targetB = "P";
        System.out.println("Given the targetA: " + targetA + " and targetB: " + targetB + " the common ancestor is: "
                + getCommonAncestor(tree, targetA, targetB).value);
        targetA = "P"; targetB = "M";
        System.out.println("Given the targetA: " + targetA + " and targetB: " + targetB + " the common ancestor is: "
                + getCommonAncestor(tree, targetA, targetB).value);

        targetA = "E"; targetB = "M";
        System.out.println("Given the targetA: " + targetA + " and targetB: " + targetB + " the common ancestor is: "
                + getCommonAncestor(tree, targetA, targetB).value);

        targetA = "E"; targetB = "F";
        System.out.println("Given the targetA: " + targetA + " and targetB: " + targetB + " the common ancestor is: "
                + getCommonAncestor(tree, targetA, targetB).value);

        targetA = "C"; targetB = "G";
        System.out.println("Given the targetA: " + targetA + " and targetB: " + targetB + " the common ancestor is: "
                + getCommonAncestor(tree, targetA, targetB).value);
    }

    private static BinaryTree<String> genTree() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("Z",
                new BinaryTreeNode<>("C",
                        new BinaryTreeNode<>("F", null, null),
                        new BinaryTreeNode<>("G",
                                new BinaryTreeNode<>("P", null, null),
                                new BinaryTreeNode<>("E", null, null))),
                new BinaryTreeNode<>("B",
                        new BinaryTreeNode<>("M", null, null),
                        new BinaryTreeNode<>("D", null, null)));
        return new BinaryTree<String>(root);
    }
}
