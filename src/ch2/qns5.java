package ch2;

import utils.LinkedListUtils;
import utils.SinglyNode;

/**
 * Sum Lists:
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 *
 * Time: O(N)
 * Space: O(N) (If I implemented the placing of results in a new linkedlist)
 */
public class qns5 {

    public static int add(SinglyNode<Integer> head1, SinglyNode<Integer> head2){
        int num1 = 0;
        int num2 = 0;
        int multiplier = 1;
        for (SinglyNode<Integer> itr = head1; itr != null; itr = itr.next) {
            num1 += multiplier*itr.element;
            multiplier*=10;
        }

        multiplier = 1;
        for (SinglyNode<Integer> itr = head2; itr != null; itr = itr.next) {
            num2 += multiplier*itr.element;
            multiplier*=10;
        }
        return (num1+num2);
    }

    public static int addForwardOrder(SinglyNode<Integer> head1, SinglyNode<Integer> head2){
        int num1 = 0;
        int num2 = 0;
        int numEle1 = 0, numEle2 = 0;
        for (SinglyNode<Integer> itr = head1; itr != null; itr = itr.next) {
            numEle1++;
        }
        int multiplier = (int)(Math.pow(10, numEle1-1));
        for (SinglyNode<Integer> itr = head1; itr != null; itr = itr.next) {
            num1 += multiplier*itr.element;
            multiplier/=10;
        }
        for (SinglyNode<Integer> itr = head2; itr != null; itr = itr.next) {
            numEle2++;
        }
        multiplier = (int)(Math.pow(10, numEle2-1));
        for (SinglyNode<Integer> itr = head2; itr != null; itr = itr.next) {
            num2 += multiplier*itr.element;
            multiplier/=10;
        }
        return (num1+num2);
    }
    public static void run() {
        SinglyNode<Integer> head1, head2;
        //Assumption: All positive numbers
        System.out.println("Digits stored in Reverse Order");
        //1st Number
        head1 = new SinglyNode<Integer>(6, null);
        head1 = new SinglyNode<Integer>(1, head1);
        head1 = new SinglyNode<Integer>(7, head1);

        //2nd Number
        head2 = new SinglyNode<Integer>(2, null);
        head2 = new SinglyNode<Integer>(9, head2);
        head2 = new SinglyNode<Integer>(5, head2);

        int ans = add(head1, head2);
        System.out.print("Adding: ");
        LinkedListUtils.printList(head1);
        System.out.print(" + ");
        LinkedListUtils.printList(head2);
        System.out.println(" = " + ans);
        System.out.println("Answer should be 912.");

        System.out.println("=========================== ");
        System.out.println("Digits stored in Normal Order");

        //1st Number
        head1 = new SinglyNode<Integer>(6, null);

        //2nd Number
        head2 = new SinglyNode<Integer>(0, null);

        ans = addForwardOrder(head1, head2);
        System.out.print("Adding: ");
        LinkedListUtils.printList(head1);
        System.out.print(" + ");
        LinkedListUtils.printList(head2);
        System.out.println(" = " + ans);
        System.out.println("Answer should be 6.");
        System.out.println("=========================== ");
        System.out.println("Digits stored in Normal Order");

        //1st Number
        head1 = new SinglyNode<Integer>(9, null);
        head1 = new SinglyNode<Integer>(9, head1);
        head1 = new SinglyNode<Integer>(9, head1);
        head1 = new SinglyNode<Integer>(9, head1);
        head1 = new SinglyNode<Integer>(9, head1);
        //2nd Number
        head2 = new SinglyNode<Integer>(1, null);

        ans = addForwardOrder(head1, head2);
        System.out.print("Adding: ");
        LinkedListUtils.printList(head1);
        System.out.print(" + ");
        LinkedListUtils.printList(head2);
        System.out.println(" = " + ans );
        System.out.println("Answer should be 100000.");
    }
}
