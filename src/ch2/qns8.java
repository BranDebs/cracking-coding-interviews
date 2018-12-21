package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

import java.util.HashSet;

/**
 * Loop Detection:
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[the same C as earlier]
 * Output: C
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns8 {

    private static SinglyNode<Character> getLoopingNode(SinglyNode<Character> head) {
        SinglyNode<Character> itr = head;
        HashSet<SinglyNode<Character>> set = new HashSet<SinglyNode<Character>>();
        while (itr != null) {
            if (set.contains(itr) == false) {
                set.add(itr);
            } else {
                return itr;
            }
            itr = itr.next;
        }

        return null;
    }

    public static void run() {

        SinglyNode<Character> head = null, temp = null;
        head = new SinglyNode<Character>('B', head);
        head = new SinglyNode<Character>('A', head);
        System.out.print("Given: ");
        LinkedListUtils.printListExact(head, 2);

        System.out.print("The looping node: ");
        head = getLoopingNode(head);
        LinkedListUtils.printListExact(head, 1);

        head = new SinglyNode<Character>('A', null);
        head.next = head;
        System.out.print("Given: ");
        LinkedListUtils.printListExact(head, 2);

        System.out.print("The looping node: ");
        head = getLoopingNode(head);
        LinkedListUtils.printListExact(head, 1);

        head= new SinglyNode<Character>('A', null);
        temp = head;
        head = new SinglyNode<Character>('B', head);
        temp.next = head;
        System.out.print("Given: ");
        LinkedListUtils.printListExact(head, 3);

        System.out.print("The looping node: ");
        head = getLoopingNode(head);
        LinkedListUtils.printListExact(head, 1);


        head= new SinglyNode<Character>('E', null);
        temp = head;
        head = new SinglyNode<Character>('D', head);
        head = new SinglyNode<Character>('C', head);
        temp.next = head;
        head = new SinglyNode<Character>('B', head);
        head = new SinglyNode<Character>('A', head);
        System.out.print("Given: ");
        LinkedListUtils.printListExact(head, 6);

        System.out.print("The looping node: ");
        head = getLoopingNode(head);
        LinkedListUtils.printListExact(head, 1);
    }
}
