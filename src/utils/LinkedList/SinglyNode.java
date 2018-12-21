package utils.LinkedList;

public class SinglyNode<V> {
    public V element;
    public SinglyNode<V> next;

    public SinglyNode(V element, SinglyNode next) {
        this.element = element;
        this.next = next;
    }
}
