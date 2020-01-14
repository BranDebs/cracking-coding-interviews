package ch2;

import utils.LinkedList.SinglyNode;

public class Qns2_8 {
  private static char loopDetection(SinglyNode<Character> head) {
    if (head == null) {
      return 0;
    }
    SinglyNode<Character> slow = head;
    SinglyNode<Character> fast = slow.next;

    int slowCnt = 1, fastCnt = 1;
    while (slow != null && fast != null) {
      slow = slow.next;
      if (fast.next == null) {
        return 0;
      }
      fast = fast.next.next;
      slowCnt++;
      fastCnt++;
      if (slow.element == fast.element) {
        break;
      }
    }
    int startCnt = slowCnt - (fastCnt/2);
    SinglyNode<Character> cur = head;

    while (startCnt > 0 ) {
      cur = cur.next;
      startCnt--;
    }
    return cur.element;
  }

  public static void tests() {
    SinglyNode<Character> loop = new SinglyNode<>('C', null);
    SinglyNode<Character> head = new SinglyNode<>('E', loop);
    head = new SinglyNode<>('D', head);
    loop.next = head;
    head = new SinglyNode<>('B', loop);
    head = new SinglyNode<>('A', head);

    printHelper(loopDetection(head));
  }

  private static void printHelper(char c) {
    System.out.printf("Output: %c", c);
  }
}
