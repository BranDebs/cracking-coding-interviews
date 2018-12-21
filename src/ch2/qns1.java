package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

import java.util.HashSet;

/**
 * Remove Dups:
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Time: 0(N)
 * Space: O(N)
 */
public class qns1 {

    private static void removeDuplicates(SinglyNode<Integer> head) {
        HashSet<Integer> foundSet = new HashSet<>();

        SinglyNode<Integer> itr = head;
        SinglyNode<Integer> prev = null;

        while (itr != null) {
            if (foundSet.contains(itr.element)) {
                    prev.next = itr.next;
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
        SinglyNode<Integer> head;
        head = new SinglyNode<Integer>(4, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        LinkedListUtils.printList(head);

        head = null;
        head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        LinkedListUtils.printList(head);

        head = null;
        head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        removeDuplicates(head);
        LinkedListUtils.printList(head);
    }

}
