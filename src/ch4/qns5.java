package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Validate BST
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * Time: O(N)
 * Space: O(lg N)
 */
public class qns5 {

    private static boolean checkBst(BinaryTreeNode<Integer> root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && (root.value <= min)) {
            return false;
        }

        if (max != null && (root.value >= max)) {
            return false;
        }

        if (!checkBst(root.left, min, root.value)) {
            return false;
        }

        if (!checkBst(root.right, root.value, max)) {
            return false;
        }
        return true;
    }

    private static boolean checkBst(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        return checkBst(root, null, null);
    }

    public static void run() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20,
                new BinaryTreeNode(10, null, new BinaryTreeNode(25, null,null)),
                new BinaryTreeNode(30, null,null));
        BinaryTree tree = new BinaryTree(root);
        System.out.println("Given the binary tree: " + tree.getInOrder());
        System.out.println("Is it a valid bst?: " + checkBst(root));

        root = new BinaryTreeNode<>( 20,
                new BinaryTreeNode<>(10,
                        new BinaryTreeNode<>(5,
                                new BinaryTreeNode<>(3, null, null),
                                new BinaryTreeNode<> (7, null, null)),
                        new BinaryTreeNode<>(15, null,
                                new BinaryTreeNode<>(17, null, null))),
                new BinaryTreeNode<>(30, null, null));
        tree = new BinaryTree(root);
        System.out.println("Given the binary tree: " + tree.getInOrder());
        System.out.println("Is it a valid bst?: " + checkBst(root));
    }

}
