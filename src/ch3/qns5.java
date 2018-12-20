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
        utils.Stack<Integer> tempStack, resultStack;
        tempStack = new utils.Stack<>();
        resultStack = new utils.Stack<>();

        //originalStack = A, tempStack = B, resultStack = C
        //Case 1: A.peek <= B.peek
        int size = originalStack.size();
        for(int i=0; i<size; i++) {
            if (tempStack.empty() /*&& resultStack.empty() */) {
                tempStack.push(originalStack.pop());
            }
            //tempStack contains stuff
            else if (!tempStack.empty()){
                if (originalStack.peek() < tempStack.peek()){
                    if(resultStack.empty()){
                        resultStack.push(tempStack.pop());
                    }
//                    else {
//                        if(resultStack.peek())
//                    }
                }
                else if (originalStack.peek() >= tempStack.peek()){

                }
            }
        }

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



    }
}
