package utils.Tree;

/**
 * Represents a binary tree
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public String getPostOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.root.value).append(" ");
        traversePostOrder(this.root, sb);
        return sb.toString();
    }

    public String getInOrder() {
        StringBuilder sb = new StringBuilder();
        traverseInOrder(this.root, sb);
        return sb.toString();
    }

    private void traversePostOrder(BinaryTreeNode<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left, sb);
        traversePostOrder(node.right, sb);
        sb.append(node.value).append(" ");
    }

    private void traverseInOrder(BinaryTreeNode<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left, sb);
        sb.append(node.value).append(" ");
        traverseInOrder(node.right, sb);
    }
}
