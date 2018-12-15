package utils;

public class LinkedListUtils {
    public static void printList(SinglyNode<?> head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("The linked list is null");
            System.out.println(sb.toString());
            return;
        }
        for (SinglyNode<?> itr = head; itr != null; itr = itr.next) {
            sb.append(itr.element);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
    public static void printListExact(SinglyNode<?> head, int count) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("The linked list is null");
            System.out.println(sb.toString());
            return;
        }
        SinglyNode<?> itr = head;
        for (int i = 0; i < count; i++) {
            sb.append(itr.element);
            sb.append(' ');
            itr = itr.next;
        }
        System.out.println(sb.toString());
    }
}
