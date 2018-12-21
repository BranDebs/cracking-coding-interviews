package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

/**
 * Delete Middle Node:
 * Implement an algorithm to delete a node in the middle (i.e. any node but the first and last node,
 * not necessarily the exact middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a -> b -> c -> d -> e -> f
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
 *
 * Time: O(1)
 * Space: O(1)
 */
public class qns3 {
    //page 106
    public static void deleteMiddle(SinglyNode<Integer> middle){

        SinglyNode<Integer> nextNode = middle.next;
        middle.element = nextNode.element;
        middle.next = nextNode.next;
    }
    public static void run() {
        SinglyNode<Integer> head, middle;
        head = new SinglyNode<Integer>(6, null);
        head = new SinglyNode<Integer>(5, head);
        head = new SinglyNode<Integer>(4, head);
        head = new SinglyNode<Integer>(3, head);
        middle = head;
        head = new SinglyNode<Integer>(2, head);
        head = new SinglyNode<Integer>(1, head);
        System.out.println("Before: ");
        LinkedListUtils.printList(head);
        deleteMiddle(middle);
        System.out.println("After: ");
        LinkedListUtils.printList(head);
        System.out.println("Answer should be 1 2 4 5 6.");

        System.out.println("=========================== ");
        head = null;
        middle = null;
        head = new SinglyNode<Integer>(1, null);
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        middle = head;
        head = new SinglyNode<Integer>(1, head);
        head = new SinglyNode<Integer>(1, head);
        System.out.println("Before: ");
        LinkedListUtils.printList(head);
        deleteMiddle(middle);
        System.out.println("After: ");
        LinkedListUtils.printList(head);
        System.out.println("Answer should be 1 1 1 1.");

    }
}
