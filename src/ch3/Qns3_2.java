package ch3;

import java.util.*;

public class Qns3_2 {
  static class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
      stack = new LinkedList<>();
      minStack = new LinkedList<>();
    }

    public int peek() {
      if (size() <= 0) {
        throw new IndexOutOfBoundsException();
      }
      return stack.peek();
    }

    public int pop() {
      if (size() <= 0) {
        throw new IndexOutOfBoundsException();
      }
      minStack.pop();
      return stack.pop();
    }

    public void push(int ele) {
      if (size() == 0) {
        minStack.push(ele);
      } else {
        if (min() > ele) {
          minStack.push(ele);
        } else {
          minStack.push(min());
        }
      }
      stack.push(ele);
    }

    public int min() {
      if (size() <= 0) {
        throw new IndexOutOfBoundsException();
      }
      return minStack.peek();
    }

    public int size() {
      return stack.size();
    }
  }

  public static void tests() {
    MinStack ms = new MinStack();
    ms.push(10);
    ms.push(1);
    ms.push(2);
    ms.push(10);
    ms.push(10);
    ms.push(3);

    int min = ms.min();
    printHelper(ms.pop(), min);

    min = ms.min();
    printHelper(ms.pop(), min);

    min = ms.min();
    printHelper(ms.pop(), min);

    min = ms.min();
    printHelper(ms.pop(), min);

    min = ms.min();
    printHelper(ms.pop(), min);

    min = ms.min();
    printHelper(ms.pop(), min);
  }

  private static void printHelper(int ele, int minEle) {
    System.out.printf("Ele: %d Min Ele: %d\n", ele, minEle);
  }
}
