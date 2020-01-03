package ch2;

import utils.LinkedList.SinglyNode;
import utils.LinkedList.LinkedListUtils;
import java.util.*;

public class Qns2_1 {
  public static SinglyNode<Integer> removeDups(SinglyNode<Integer> head) {
    HashMap<Integer, Integer> wordFreqs = new HashMap<>();
    SinglyNode<Integer> cur = head;
    while (cur != null) {
      if (wordFreqs.containsKey(cur.element)) {
        int freq = wordFreqs.get(cur.element);
        wordFreqs.put(cur.element, freq+1);
      } else {
        wordFreqs.put(cur.element, 1);
      }
      cur = cur.next;
    }
    cur = new SinglyNode<>(null, head);
    head = cur;
    while (cur.next != null) {
      int freq = wordFreqs.get(cur.next.element);
      if (freq > 1) {
        wordFreqs.put(cur.next.element, freq - 1);
        removeNextNode(cur);
      } else {
        cur = cur.next;
      }
    }
    return head.next;
  }

  public static void tests() {
    SinglyNode empty = null;

    LinkedListUtils.printList(removeDups(empty));

    SinglyNode<Integer> noDups = new SinglyNode<>(5, null);
    noDups = new SinglyNode<>(4, noDups);
    noDups = new SinglyNode<>(3, noDups);
    noDups = new SinglyNode<>(100, noDups);
    noDups = new SinglyNode<>(77, noDups);
    noDups = new SinglyNode<>(1, noDups);

    LinkedListUtils.printList(removeDups(noDups));

    SinglyNode<Integer> dups1 = new SinglyNode<>(10,null);
    dups1 = new SinglyNode<>(9, dups1);
    dups1 = new SinglyNode<>(10, dups1);

    LinkedListUtils.printList(removeDups(dups1));

    SinglyNode<Integer> dup2 = new SinglyNode<>(3, null);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);
    dup2 = new SinglyNode<>(3, dup2);

    LinkedListUtils.printList(removeDups(dup2));

    SinglyNode<Integer> dup3 = new SinglyNode<>(10, null);
    dup3 = new SinglyNode<>(10, dup3);
    dup3 = new SinglyNode<>(10, dup3);
    dup3 = new SinglyNode<>(100, dup3);

    LinkedListUtils.printList(removeDups(dup3));

    SinglyNode<Integer> dup4 = new SinglyNode<>(3, null);
    dup4 = new SinglyNode<>(3, dup4);
    dup4 = new SinglyNode<>(4, dup4);
    dup4 = new SinglyNode<>(3, dup4);
    dup4 = new SinglyNode<>(4, dup4);
    dup4 = new SinglyNode<>(3, dup4);
    dup4 = new SinglyNode<>(4, dup4);
    dup4 = new SinglyNode<>(3, dup4);

    LinkedListUtils.printList(removeDups(dup4));

    SinglyNode<Integer> dup5 = new SinglyNode<>(3, null);
    dup5 = new SinglyNode<>(3, dup5);
    dup5 = new SinglyNode<>(4, dup5);
    dup5 = new SinglyNode<>(7, dup5);
    dup5 = new SinglyNode<>(4, dup5);
    dup5 = new SinglyNode<>(3, dup5);
    dup5 = new SinglyNode<>(5, dup5);
    dup5 = new SinglyNode<>(3, dup5);
    dup5 = new SinglyNode<>(4, dup5);
    dup5 = new SinglyNode<>(5, dup5);
    dup5 = new SinglyNode<>(5, dup5);
    dup5 = new SinglyNode<>(3, dup5);
    dup5 = new SinglyNode<>(9, dup5);

    LinkedListUtils.printList(removeDups(dup5));

  }

  private static void removeNextNode(SinglyNode<Integer> node) {
    if (node == null) {
      throw new NullPointerException();
    }
    node.next = node.next.next;
  }
}
