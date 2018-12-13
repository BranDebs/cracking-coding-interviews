package utils;

public class LinkedListUtils {
    public static void printList(SinglyNode<Integer> head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("The linked list is null");
            System.out.println(sb.toString());
            return;
        }
        for (SinglyNode<Integer> itr = head; itr != null; itr = itr.next) {
            sb.append(itr.element);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
