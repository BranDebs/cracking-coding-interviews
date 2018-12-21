package ch2;

import utils.LinkedList.SinglyNode;

/**
 * Intersection:
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the
 * first linked list is the exact same node (by reference) as the jth node of the second linked list,
 * then they are intersecting.
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns7 {

    public static boolean isIntersecting(SinglyNode<Integer> head1, SinglyNode<Integer> head2) {
        //make the linkedlist same size
        int size1 = 0;
        int size2 = 0;
        int shorterSize;
        SinglyNode<Integer> longerLinkedList, shorterLinkedList;
        for (SinglyNode<Integer> itr = head1; itr != null; itr = itr.next) {
            size1++;
        }
        for (SinglyNode<Integer> itr = head2; itr != null; itr = itr.next) {
            size2++;
        }
        int diff = Math.abs(size1-size2);
        if(size1>size2){
            longerLinkedList = head1;
            shorterLinkedList = head2;
            shorterSize = size2;
        }
        else{
            longerLinkedList = head2;
            shorterLinkedList = head1;
            shorterSize = size1;
        }
        while (diff!=0){
            longerLinkedList = longerLinkedList.next;
            diff--;
        }

        while(shorterSize!=0){
            if(longerLinkedList == shorterLinkedList){
                return true;
            }
            longerLinkedList = longerLinkedList.next;
            shorterLinkedList = shorterLinkedList.next;
            shorterSize--;
        }
        return false;
    }

    public static void run() {
        SinglyNode<Integer> head1, head2, intersection;
        head1 = new SinglyNode<Integer>(6, null);
        head1 = new SinglyNode<Integer>(5, head1);
        head1 = new SinglyNode<Integer>(4, head1);
        head1 = new SinglyNode<Integer>(3, head1);
        intersection = head1;
        head1 = new SinglyNode<Integer>(2, head1);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(7, head1);

        head2 = new SinglyNode<Integer>(8, intersection);
        head2 = new SinglyNode<Integer>(6, head2);
        head2 = new SinglyNode<Integer>(7, head2);
        head2 = new SinglyNode<Integer>(8, head2);
        head2 = new SinglyNode<Integer>(9, head2);
        head2 = new SinglyNode<Integer>(6, head2);
        head2 = new SinglyNode<Integer>(7, head2);
        head2 = new SinglyNode<Integer>(8, head2);
        head2 = new SinglyNode<Integer>(9, head2);

        //intersection is at 3

        boolean intersecting = isIntersecting(head1, head2);
        System.out.println(intersecting);
        System.out.println("Answer should be true.");

        System.out.println("=========================== ");

        head1 = new SinglyNode<Integer>(1, null);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(1, head1);

        head2 = new SinglyNode<Integer>(1, null);
        head2 = new SinglyNode<Integer>(1, head2);
        head2 = new SinglyNode<Integer>(1, head2);
        head2 = new SinglyNode<Integer>(1, head2);
        head2 = new SinglyNode<Integer>(1, head2);
        head2 = new SinglyNode<Integer>(1, head2);
        head2 = new SinglyNode<Integer>(1, head2);
        //no intersection

        intersecting = isIntersecting(head1, head2);
        System.out.println(intersecting);
        System.out.println("Answer should be false.");


    }
}