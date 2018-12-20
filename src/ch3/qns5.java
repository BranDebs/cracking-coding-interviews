package ch3;

/**
 * Sort Stack:
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into
 * any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 */
public class qns5 {
    private static utils.Stack<Integer> stack;

    private static utils.Stack<Integer> sortStack(utils.Stack<Integer> originalStack){
        utils.Stack<Integer> tempStack;
        tempStack = new utils.Stack<>();
        int temp;
        int counter;
        //originalStack = A, tempStack = B
        while (!originalStack.empty()) {
            if (tempStack.empty()){
                tempStack.push(originalStack.pop());
            }
            else if(originalStack.peek() <= tempStack.peek()){
                tempStack.push(originalStack.pop());
            }
            else if(originalStack.peek() > tempStack.peek()){
                counter = 0;
                temp = originalStack.peek();
                while(!tempStack.empty()){
                    //transferring items from B to A
                    if(tempStack.peek()<temp){
                        originalStack.push(tempStack.pop());
                        counter++;
                    }
                    else {
                        break;
                    }
                }
                tempStack.push(temp);
                for (int i=0; i<counter; i++){
                    tempStack.push(originalStack.pop());
                }
                originalStack.pop();
            }
        }
        return tempStack;
    }
    public static void run() {
        stack = new utils.Stack<>();

        //Stack 1
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(0);
        stack.push(5);

        utils.Stack<Integer> sortedStack = sortStack(stack);
        int size = sortedStack.size();
        System.out.println("RHS of the printed stack is the bottom");
        System.out.println("Original Stack: 5 0 3 6 2 1");
        System.out.println("Final Stack: ");
        for (int i=0; i<size; i++){
            System.out.print(sortedStack.pop() + " ");
        }


    }
}
