package ch3;

/**
 * Stack Min
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * Time: O(1) for push pop and min
 * Space: O(N)
 */
public class qns2 {

    private class StackMin<T> {
        private utils.Stack<T> stack, min;

        public void push(T element) {
            stack.push(element);
        }

        public T pop() {
            T output = stack.pop();
            return output;
        }
    }

    public static void run() {

    }
}
