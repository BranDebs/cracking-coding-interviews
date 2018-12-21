package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

/**
 * Return Kth to Last:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns2 {

    private static SinglyNode<Integer> getKthToLast(SinglyNode<Integer> head, int k) {
        SinglyNode<Integer> output = null;

        int count = 0;

        for (SinglyNode<Integer> itr = head; itr != null; itr = itr.next) {
            count += 1;
            if (count == k) {
                return itr;
            }
        }

        return null;
    }

    public static void run() {
        SinglyNode<Integer> head, output;
        head = new SinglyNode<Integer>(4, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        output = getKthToLast(head, 2);
        LinkedListUtils.printList(output);

        output = getKthToLast(head, 6);
        LinkedListUtils.printList(output);
    }
}
