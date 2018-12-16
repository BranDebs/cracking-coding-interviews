package ch2;

import utils.SinglyNode;

public class qns7 {

    public static boolean isIntersecting(SinglyNode<Integer> head1, SinglyNode<Integer> head2) {
        SinglyNode<Integer> pointer1, pointer2;
        for (SinglyNode<Integer> itr = head1; itr != null; itr = itr.next) {
            for (SinglyNode<Integer> jtr = head2; jtr != null; jtr = jtr.next) {
                if (itr == jtr) {
                    return true;
                }
            }
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

        head2 = new SinglyNode<Integer>(9, null);
        head2 = new SinglyNode<Integer>(7, head2);
        intersection.next = head2;
        head2 = new SinglyNode<Integer>(8, intersection);
        head2 = new SinglyNode<Integer>(6, head2);
        head2 = new SinglyNode<Integer>(7, head2);
        head2 = new SinglyNode<Integer>(8, head2);
        head2 = new SinglyNode<Integer>(9, head2);
        //intersection is at 3

        boolean intersecting = isIntersecting(head1, head2);
        System.out.println(intersecting);

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

    }
}