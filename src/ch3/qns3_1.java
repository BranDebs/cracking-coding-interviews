package ch3;

import java.util.*;

public class qns3_1 {
  private static class ThreeStack {
    private String[] elements;
    private int[] sizes;
    private int capacity;
    public ThreeStack(int capacity) {
      this.elements = new String[capacity*3];
      this.sizes = new int[3];
      this.capacity = capacity;
    }

    public void push(int stackNum, String val) {
      if (this.size() >= this.elements.length) {
        throw new ArrayIndexOutOfBoundsException();
      }
      this.sizes[stackNum]++;
      this.elements[sizes[stackNum] + (stackNum * this.capacity) - 1] = val;
    }

    public String pop(int stackNum) {
      String elem = peek(stackNum);
      this.sizes[stackNum]--;
      return elem;
    }

    public String peek(int stackNum) {
      if (this.sizes[stackNum] < 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      String elem = this.elements[(this.sizes[stackNum]) + (stackNum * this.capacity) - 1];
      return elem;
    }

    public int size() {
      int len = 0;
      for(int s : this.sizes) {
        len += s;
      }
      return len;
    }
  }

  public static void tests() {
    ThreeStack stack = new ThreeStack(1);

    stack.push(0, "1");
    stack.push(1, "2");
    stack.push(2, "3");

    System.out.println(stack.size());
    System.out.println(stack.pop(1));
    System.out.println(stack.pop(0));
    System.out.println(stack.pop(2));

    stack = new ThreeStack(5);
    stack.push(0, "00");
    stack.push(0, "01");
    stack.push(0, "02");

    stack.push(2, "20");
    stack.push(2, "21");

    stack.push(1, "10");
    stack.push(1, "11");
    stack.push(1, "12");
    stack.push(1, "13");

    System.out.println(stack.size());
    System.out.println(stack.pop(1));
    System.out.println(stack.pop(1));
    System.out.println(stack.size());
    System.out.println(stack.pop(1));

    System.out.println(stack.pop(0));
    System.out.println(stack.pop(0));
  }
}
