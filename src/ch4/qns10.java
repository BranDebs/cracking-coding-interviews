package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Check Subtree
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorith m to determine if T2 is a subtree of Tl .
 * A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 *
 * Time:
 * Space:
 */
public class qns10 {

    private static boolean isSubtree(BinaryTree<String> T1, BinaryTree<String> T2) {
        return traverseTree(T1.getRoot(), T2.getRoot());
    }

    private static boolean traverseTree(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {
        if (node1 == null) {
            return false;
        }
        if (node1.value.equals(node2.value)) {
            return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);
        }
        return traverseTree(node1.left, node2) || traverseTree(node1.right, node2);
    }

    private static boolean isSubtree(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (!node1.value.equals(node2.value)) {
            return false;
        }
        return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);
    }

    public static void run() {
        BinaryTree<String> tree = genTree();
        BinaryTree<String> subtree = new BinaryTree( new BinaryTreeNode<>("B",
                new BinaryTreeNode<>("M", null, null),
                new BinaryTreeNode<>("D", null, null)));
        System.out.print("=== Given the tree " + tree.getInOrder() + " subtree " + subtree.getInOrder() + " is subtree: ");
        System.out.println(isSubtree(tree, subtree));

        BinaryTree<String> nosubtree = new BinaryTree( new BinaryTreeNode<>("B",
                new BinaryTreeNode<>("M", null, null),
                new BinaryTreeNode<>("G", null, null)));
        System.out.print("=== Given the tree " + tree.getInOrder() + " subtree " + nosubtree.getInOrder() + " is subtree: ");
        System.out.println(isSubtree(tree, nosubtree));
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
