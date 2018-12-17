package utils;

public class Stack<T> {
    private class StackNode<T> {
        public T element;
        public StackNode next;

        public StackNode(T element, StackNode next) {
            this.element = element;
            this.next = next;
        }
    }

    protected StackNode<T> head = null;
    protected int size = 0;

    public void push(T element) {
        size++;
        if (head == null) {
            head = new StackNode<T>(element, null);
            return;
        }
        head = new StackNode<T>(element, head);
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        size--;
        T output = head.element;
        head = head.next;
        return output;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.element;
    }
}
