package ch3;

/**
 * Stack Min
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * Time: O(1) for push pop and min
 * Space: O(N)
 */

class StackMin<T extends Comparable<T>> {
    private utils.Stack<T> stack, min;

    public StackMin() {
        stack = new utils.Stack();
        min = new utils.Stack();
    }

    public void push(T element) {
        stack.push(element);
        if (min.size() == 0) {
            min.push(element);
            return;
        }
        T top = min.peek();
        if (element.compareTo(top) < 0) {
            min.push(element);
        } else {
            min.push(top);
        }
    }

    public T pop() {
        T output = stack.pop();
        if (output == null) {
            return output;
        }
        min.pop();
        return output;
    }

    public T peek() {
        return stack.peek();
    }

    public T getMin() {
        return min.peek();
    }

    public int size() {
        return stack.size();
    }
}


public class qns2 {
    public static void run() {
        StackMin<Integer> minStack = new StackMin<Integer>();
        minStack.push(7);
        minStack.push(2);
        minStack.push(8);
        minStack.push(3);
        minStack.push(4);
        minStack.push(1);

        while (minStack.size() != 0) {
            System.out.print("Before pop: ");
            System.out.println(minStack.peek() + " getMin: " + minStack.getMin());
            minStack.pop();
        }

        System.out.println("===");

        minStack = new StackMin<Integer>();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(6);

        while (minStack.size() != 0) {
            System.out.print("Before pop: ");
            System.out.println(minStack.peek() + " getMin: " + minStack.getMin());
            minStack.pop();
        }

        System.out.println("===");

        minStack = new StackMin<Integer>();
        minStack.push(6);
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);

        while (minStack.size() != 0) {
            System.out.print("Before pop: ");
            System.out.println(minStack.peek() + " getMin: " + minStack.getMin());
            minStack.pop();
        }
    }
}
