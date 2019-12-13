package ch2;

import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

public class Qns2_4 {
  private static SinglyNode<Integer> partition(SinglyNode<Integer> head, int pivot) {
    SinglyNode<Integer> left = null, right = null;

    SinglyNode<Integer> cur = head;
    SinglyNode<Integer> leftCur = left, rightCur = right;

    while (cur != null) {
      if (cur.element < pivot) {
        if (leftCur == null) {
          leftCur = new SinglyNode<>(cur.element, null);
          left = leftCur;

        } else {
          leftCur.next = new SinglyNode<>(cur.element, null);
          leftCur = leftCur.next;
        }
      } else {
        if (rightCur == null) {
          rightCur = new SinglyNode<>(cur.element, null);
          right = rightCur;
        } else {
          rightCur.next = new SinglyNode<>(cur.element, null);
          rightCur = rightCur.next;
        }
      }
      cur = cur.next;
    }

//    SinglyNode<Integer> leftTail = left;
//
//    if (leftTail != null) {
//      while(leftTail.next != null) {
//        leftTail = leftTail.next;
//      }
//    }
//    leftTail.next = right;
    if (leftCur != null) {
      leftCur.next = right;
    } else {
      left = right;
    }

    return left;
  }


  public static void tests() {
    // 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1
    SinglyNode<Integer> head = new SinglyNode<>(1, null);
    head = new SinglyNode<>(2, head);
    head = new SinglyNode<>(10, head);
    head = new SinglyNode<>(5, head);
    head = new SinglyNode<>(8, head);
    head = new SinglyNode<>(5, head);
    head = new SinglyNode<>(3, head);

    SinglyNode<Integer> ans = partition(head, 5);
    LinkedListUtils.printList(ans);

    ans = partition(head, 0);
    LinkedListUtils.printList(ans);

    ans = partition(head, 10000);
    LinkedListUtils.printList(ans);

    ans = partition(head, 10);
    LinkedListUtils.printList(ans);

    ans = partition(head, 2);
    LinkedListUtils.printList(ans);
  }
}
