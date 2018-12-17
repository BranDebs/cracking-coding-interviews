package ch3;

import java.util.Stack;

/**
 * Stack of Plates:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
 * we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack
 * once the previous one exceeds capacity. SetOfStacks. push () and SetOfStacks. pop () should behave identically
 * to a single stack (that is, pop ( ) should return the same values as it would if there were just a single stack).
 *
 FOLLOW UP
 Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 * Time: O(1) for push and pop
 * Space: O(N^2)
 */
public class qns3 {

    public static class SetOfStacks{
        Stack<Stack<Integer>> stackSequence;
        int threshold;

        public SetOfStacks(int threshold){
            stackSequence = new Stack<>();
            this.threshold = threshold;
            Stack newStack = new Stack<Integer>();
            stackSequence.add(newStack);
        }

        public void push(int element){
            if(stackSequence.peek().size()<threshold){
                //Case 1: Add normally, no overflow

                Stack myStack = stackSequence.pop();
                myStack.push(element);
                stackSequence.push(myStack);
            }
            else {
                //Case 2: Overflow occurs, create new stack, update stackSequence
                Stack newStack = new Stack<>();
                newStack.push(element);
                stackSequence.push(newStack);
            }
        }

        public int pop(){
            System.out.println(stackSequence.size());
            if(stackSequence.peek().size()==0){
                //Case 2: An empty stack in my set of stacks =(, delete old stack, update stackSequence
                stackSequence.pop();
                Stack<Integer> myStack = stackSequence.pop();
                int element = myStack.pop();
                stackSequence.push(myStack);
                return element;
            }
            else {
                //Case 1: Delete normally, no empty stack in my little setOfStacks
                Stack<Integer> myStack = stackSequence.pop();
                int element = myStack.pop();
                stackSequence.push(myStack);
                return element;

            }

        }
        public int stacksize(){
            return stackSequence.size();
        }
        public void printer(){
            int ele;
            int counter = stackSequence.size();
            Stack<Stack<Integer>> duplicateStack = (Stack<Stack<Integer>>)stackSequence.clone();
            while (!duplicateStack.empty()){
                Stack<Integer> myStack = duplicateStack.pop();
                System.out.println("Stack " + counter + ":");
                while(!myStack.empty()){
                    ele = myStack.pop();
                    System.out.print(ele + ", ");
                }
                System.out.println();
                counter--;
            }
            System.out.println("PRINTING DONE!");
            System.out.println("=========================== ");

        }

    }

    public static void run() {
        int popped;
        SetOfStacks hugeStack = new SetOfStacks(3);
        hugeStack.push(1);
        hugeStack.push(2);
        hugeStack.push(3);
        hugeStack.push(11);
        hugeStack.push(12);
        hugeStack.push(13);
        hugeStack.push(14);
        hugeStack.push(15);
        hugeStack.push(16);
        hugeStack.push(17);
        System.out.println(hugeStack.stacksize());
        System.out.println("HELLO");
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        hugeStack.push(999999);
        //hugeStack.printer();

        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        popped = hugeStack.pop();
        System.out.println("Popped: " + popped);
        hugeStack.printer();

    }
}
