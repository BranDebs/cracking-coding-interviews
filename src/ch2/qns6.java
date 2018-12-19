package ch2;

import utils.LinkedListUtils;
import utils.SinglyNode;

import java.util.Stack;

/**
 * Palindrome:
 * Implement a function to check if a linked list is a palindrome.
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns6 {

        private static boolean isPalindrome(SinglyNode<Integer> head) {
            Stack<Integer> stack = new Stack<Integer>();
            int size = 0, curCount = 0;
            for (SinglyNode<Integer> itr = head; itr != null; itr = itr.next) {
                size += 1;
            }
            for (SinglyNode<Integer> itr = head; itr != null; itr = itr.next) {
                curCount += 1;
                if (curCount <= size / 2) {
                    stack.push(itr.element);
                } else {
                    if (size % 2 != 0) {
                        if (curCount - (size / 2) == 1) {
                            continue;
                        }
                    }
                    int val = stack.pop();
                    if (val != itr.element) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void run() {
            SinglyNode<Integer> head = null;
            head = new SinglyNode<Integer>(1, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(1, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(1, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));


            head = null;
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(2, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            head = new SinglyNode<Integer>(3, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(2, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(3, head);
            head = new SinglyNode<Integer>(1, head);
            head = new SinglyNode<Integer>(2, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));

            head = null;
            head = new SinglyNode<Integer>(5, head);
            head = new SinglyNode<Integer>(4, head);
            head = new SinglyNode<Integer>(3, head);
            head = new SinglyNode<Integer>(2, head);
            head = new SinglyNode<Integer>(1, head);
            System.out.print("Given: ");
            LinkedListUtils.printList(head);
            System.out.println("Is Palindome?: " + isPalindrome(head));
        }
}
