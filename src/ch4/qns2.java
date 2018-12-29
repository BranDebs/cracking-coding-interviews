package ch4;

import utils.Tree.BinaryTree;
import utils.Tree.BinaryTreeNode;

/**
 * Minimal Tree
 * Given a sorted (increasing order) array with unique integer elements, write an algo-
 * rithm to create a binary search tree with minimal height.
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns2 {

    /**
     * Traverses the array to construct the min binary tree
     * @param left left side boundary of the array
     * @param right right side boundary of the array is inclusive.
     * @return node if any
     */
    private static BinaryTreeNode<Integer> traverseArr(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            BinaryTreeNode<Integer> leftNode = traverseArr(arr, left, mid - 1);
            BinaryTreeNode<Integer> rightNode = traverseArr(arr, mid + 1, right);
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[mid], leftNode, rightNode);
            return node;
        }
        return null;
    }

    public static BinaryTree<Integer> getMinimalTree(int[] arr) {
        BinaryTree<Integer> minTree = null;

        if (arr.length < 1) {
            return null;
        }

        if (arr.length == 1) {
            return new BinaryTree<>(new BinaryTreeNode<>(arr[0],null,null));
        }

        BinaryTreeNode<Integer> root = traverseArr(arr, 0, arr.length - 1);
        minTree = new BinaryTree<>(root);
        return minTree;
    }

    public static void run() {
        int[] arr1 = {0,3,4,5,8};
        BinaryTree<Integer> tree = getMinimalTree(arr1);
        printOutput(arr1, tree);

        int[] arr2 = {1,2,3,4,5,6};
        tree = getMinimalTree(arr2);
        printOutput(arr2, tree);

        int[] arr3 = {1};
        tree = getMinimalTree(arr3);
        printOutput(arr3, tree);
    }

    private static void printOutput(int[] arr, BinaryTree<Integer> tree) {
        System.out.print("Given the array [ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("] the binary tree is in post order:  ");
        System.out.println(tree.getInOrder());
    }
}
