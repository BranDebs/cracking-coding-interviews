package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

/**
 * Partition:
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x.lf x is contained within the list,
 * the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition"; it does not
 * need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 (partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns4 {

    private static SinglyNode<Integer> paritionLinkedList(SinglyNode<Integer> head, int partition) {
        SinglyNode<Integer> itr = head, l = null, h = null, newHead = head;
        while (itr != null) {
            if (itr.element < partition) {
                if (l == null) {
                    l = itr;
                    newHead = l;
                    if (head != itr && head.element >= partition) {
                        itr = itr.next;
                        l.next = head;
                        continue;
                    }
                } else {
                    SinglyNode<Integer> temp = l.next;
                    l.next = itr;
                    itr = itr.next;
                    l = l.next;
                    l.next = temp;
                    continue;
                }
            } else {
                if (h == null) {
                    h = itr;
                } else {
                    h.next = itr;
                    itr = itr.next;
                    h = h.next;
                    h.next = null;
                    continue;
                }
            }
            itr = itr.next;
        }
        return newHead;
    }

    public static void run() {
        int partition = 5;
        SinglyNode<Integer> head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<>(2, head);
        head = new SinglyNode<>(10, head);
        head = new SinglyNode<>(5, head);
        head = new SinglyNode<>(8, head);
        head = new SinglyNode<>(5, head);
        head = new SinglyNode<>(3, head);

        System.out.print("Before: ");
        LinkedListUtils.printList(head);
        System.out.print("After with " + partition +" as the partition: ");
        head = paritionLinkedList(head, partition);
        LinkedListUtils.printList(head);

        partition = 7;
        head = null;
        head = new SinglyNode<>(4, head);
        head = new SinglyNode<>(10, head);
        head = new SinglyNode<>(3, head);
        head = new SinglyNode<>(9, head);
        head = new SinglyNode<>(2, head);
        head = new SinglyNode<>(8, head);
        head = new SinglyNode<>(1, head);

        System.out.print("Before: ");
        LinkedListUtils.printList(head);
        System.out.print("After with " + partition +" as the partition: ");
        head = paritionLinkedList(head, partition);
        LinkedListUtils.printList(head);

        partition = 6;
        head = null;
        head = new SinglyNode<>(4, head);
        head = new SinglyNode<>(10, head);
        head = new SinglyNode<>(3, head);
        head = new SinglyNode<>(9, head);
        head = new SinglyNode<>(2, head);
        head = new SinglyNode<>(8, head);
        head = new SinglyNode<>(1, head);
        head = new SinglyNode<>(11, head);

        System.out.print("Before: ");
        LinkedListUtils.printList(head);
        System.out.print("After with " + partition +" as the partition: ");
        head = paritionLinkedList(head, partition);
        LinkedListUtils.printList(head);

        partition = 1;
        head = null;
        head = new SinglyNode<>(4, head);
        head = new SinglyNode<>(10, head);
        head = new SinglyNode<>(3, head);
        head = new SinglyNode<>(9, head);
        head = new SinglyNode<>(2, head);
        head = new SinglyNode<>(8, head);
        head = new SinglyNode<>(1, head);
        head = new SinglyNode<>(11, head);
        head = new SinglyNode<>(14, head);

        System.out.print("Before: ");
        LinkedListUtils.printList(head);
        System.out.print("After with " + partition +" as the partition: ");
        head = paritionLinkedList(head, partition);
        LinkedListUtils.printList(head);
    }
}
