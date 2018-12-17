package ch3;

import utils.Stack;

import java.util.Arrays;

class MyQueue<T> {
    Stack<T> queue, rev;

    public MyQueue() {
        queue = new Stack<T>();
        rev = new Stack<T>();
    }

    public void offer(T element) {
        if (queue.empty()) {
            queue.push(element);
            return;
        }
        while (queue.empty() == false) {
            rev.push(queue.pop());
        }
        queue.push(element);
        while(rev.empty() == false) {
            queue.push(rev.pop());
        }
    }

    public T poll() {
        if (queue.empty()) {
            return null;
        }
        return queue.pop();
    }

    public T peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Queue via Stacks
 *  Implement a MyQueue class which implements a queue using two stacks.
 *
 * Time: O(N)
 * Space: O(N)
 */
public class qns4 {

    public static void run() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        int[] arr = {8, 5, 4, 3, 2, 1};

        for (int i : arr) {
            queue.offer(i);
        }

        System.out.print("Insertion sequence: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("The queue poll seqeuence: ");
        while(queue.empty() == false) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
