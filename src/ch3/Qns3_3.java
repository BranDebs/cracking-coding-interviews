package ch3;

import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Qns3_3 {

  // Assume that the items that we are storing is integers
  public static class SetOfStacks {
    private int capacity;
    private Deque<Deque<Integer>> stacks;
    private int activeStack;

    public SetOfStacks(int capacity) {
      if (capacity < 1) {
        throw new InvalidParameterException();
      }
      this.capacity = capacity;
      this.stacks = new LinkedList<>();
      this.activeStack = 0;
    }

    public void push(int elem) {
      if (numStacks() == 0) {
        Deque<Integer> newStack = newStack(elem);
        stacks.push(newStack);
      } else {
        Deque<Integer> curStack = stacks.peek();
        if (curStack.size() >= capacity) {
          Deque<Integer> newStack = newStack(elem);
          stacks.push(newStack);
        } else {
          curStack.push(elem);
        }
      }
    }

    private Deque newStack(int elem) {
      Deque<Integer> newStack = new ArrayDeque<>(capacity);
      newStack.push(elem);
      return newStack;
    }

    public int pop() {
      if (numStacks() == 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      Deque<Integer> curStack = stacks.peek();
      int out = curStack.pop();
      if (curStack.size() == 0) {
        stacks.pop();
      }
      return out;
    }

    public int popAt(int idx) {
      if (idx >= numStacks()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      activeStack = idx;
      Iterator<Deque<Integer>> itr = stacks.iterator();
      Deque<Integer> stack = itr.next();
      for (int i = 0; i < numStacks() - idx - 1; i++) {
        stack = itr.next();
      }
      if (stack.size() == 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      int out = stack.pop();
      return out;
    }

    public int peek() {
      if (numStacks() == 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      Deque<Integer> curStack = stacks.peek();
      return curStack.peek();
    }

    public int numStacks() {
      return stacks.size();
    }
  }

  public static void tests() {
    SetOfStacks ss1 = new SetOfStacks(1);
    ss1.push(10);
    ss1.push(2);
    int out = ss1.pop();
    printHelper(ss1, out);// (1) (2)
    out = ss1.pop();
    printHelper(ss1, out);// (0) (1)

    SetOfStacks ss2 = new SetOfStacks(5);
    ss2.push(10);
    out = ss2.pop();
    printHelper(ss2, out);
    ss2.push(4);
    out = ss2.pop();
    printHelper(ss2, out);

    SetOfStacks ss3 = new SetOfStacks(2);
    ss3.push(1);
    printHelper(ss3, ss3.peek());
    ss3.push(10);
    printHelper(ss3, ss3.peek());
    ss3.push(11);
    printHelper(ss3, ss3.peek());
    out = ss3.popAt(0);
    printHelper(ss3, out);

    SetOfStacks ss4 = new SetOfStacks(1);
    ss4.push(1);
    ss4.push(2);
    ss4.push(3);
    out = ss4.popAt(1);
    printHelper(ss4, out);
  }

  private static void printHelper(SetOfStacks ss, int val) {
    System.out.printf("Num of Stacks (%d) Val (%d)\n", ss.numStacks(), val);
  }
}
