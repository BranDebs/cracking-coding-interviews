package ch2;

import org.omg.CORBA.INTERNAL;
import utils.SinglyNode;

import java.util.HashSet;

public class qns1 {

    private static SinglyNode<Integer> head;

    private static void removeDuplicates(SinglyNode<Integer> head) {
        HashSet<Integer> foundSet = new HashSet<>();

        SinglyNode<Integer> itr = head;
        SinglyNode<Integer> prev = null;

        while (itr != null) {
            if (foundSet.contains(itr.element)) {
//                if (!prev.element.equals(itr.element)) {
                    prev.next = itr.next;
//                }
            } else {
                foundSet.add(itr.element);
                prev = itr;
            }
            itr = itr.next;
        }
        prev.next = null;
//        for (SinglyNode<Integer> itr = head; itr != null; prev = itr, itr = itr.next) {
//            if (wordsFound.contains(itr.element)) {
//                prev.next = itr.next;
//            } else {
//                wordsFound.add(itr.element);
//            }
//        }
    }

    public static void run() {

        head = new SinglyNode<Integer>(4, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        printList(head);

        head = null;
        head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        printList(head);

        head = null;
        head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        printList(head);
    }

    private static void printList(SinglyNode<Integer> head) {
        StringBuilder sb = new StringBuilder();
        for (SinglyNode<Integer> itr = head; itr != null; itr = itr.next) {
            sb.append(itr.element);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
