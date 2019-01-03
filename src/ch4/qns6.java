package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Successor
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns6 {
    private static BinaryTreeNode<String> getSucessor(BinaryTree tree, String node) {
        return getSucessor(tree.getRoot(), node);
    }

    private static BinaryTreeNode<String> getSucessor(BinaryTreeNode<String> node, String target) {
        if (node == null) {
            return null;
        }
        if (node.value.equals(target)) {
            // Check the right node
            if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        } else {
            BinaryTreeNode<String> child = null;
            if (node.value.compareTo(target) > 0) {
                child = getSucessor(node.left, target);
                if (child == null) {
                    return node;
                }
            } else if (node.value.compareTo(target) < 0) {
                child = getSucessor(node.right, target);

            }
            return child;
        }
    }

    public static void run() {
        BinaryTree<String> unbalanced = genUnbalancedTree();
        System.out.println("=== unskewed tree " + unbalanced.getInOrder() + " ===");
        String target = "D";
        System.out.print("Given the target " + target + " the sucessor is: ");
        System.out.println(getSucessor(unbalanced, target).value);

        target = "C";
        System.out.print("Given the target " + target + " the sucessor is: ");
        System.out.println(getSucessor(unbalanced, target).value);

        target = "A";
        System.out.print("Given the target " + target + " the sucessor is: ");
        System.out.println(getSucessor(unbalanced, target).value);

        target = "B";
        System.out.print("Given the target " + target + " the sucessor is: ");
        System.out.println(getSucessor(unbalanced, target).value);

        target = "E";
        System.out.print("Given the target " + target + " the sucessor is: ");
//        System.out.println(getSucessor(unbalanced, target).value);
        BinaryTreeNode<String> node = getSucessor(unbalanced, target);
        if (node == null) {
            System.out.println("Is not found");
        }

        BinaryTree<String> skewed = genUnbalancedTreeSkewed();
        System.out.println("=== unskewed tree " + skewed.getInOrder() + " ===");
        target = "B";
        System.out.print("Given the target " + target + " the sucessor is: ");
        System.out.println(getSucessor(skewed, target).value);
    }

    private static BinaryTree<String> genUnbalancedTree() {
        BinaryTreeNode<String> root;
        BinaryTreeNode<String> left = new BinaryTreeNode<>("B",
                new BinaryTreeNode<>("A", null, null),
                new BinaryTreeNode<>("C", null, null));
        BinaryTreeNode<String> right = new BinaryTreeNode<>("E", null, null);
        root = new BinaryTreeNode<String>("D", left, right);
        return new BinaryTree<String>(root);
    }

    private static BinaryTree<String> genUnbalancedTreeSkewed() {
        BinaryTreeNode<String> root;
        BinaryTreeNode<String> left = new BinaryTreeNode<>("B",
                new BinaryTreeNode<>("A", null, null),
                null);
        BinaryTreeNode<String> right = new BinaryTreeNode<>("E", null, null);
        root = new BinaryTreeNode<String>("D", left, right);
        return new BinaryTree<String>(root);
    }
}
