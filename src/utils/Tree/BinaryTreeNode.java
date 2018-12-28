package utils.Tree;

/**
 * Represents a binary tree node
 */
public class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(T value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
