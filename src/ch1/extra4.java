package ch1;

import java.util.Stack;

/**
 * Largest Rectangular Area in a Histogram
 * Find the largest rectangular area possible in a given histogram
 * where the largest rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 *
 * Time:
 * Space:
 */
public class extra4 {

    public static int getLargestRect(int[] arr) {
        int maxRect = 0;
        Stack<Integer> posStack = new Stack<Integer>();
        Stack<Integer> heightStack = new Stack<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if (posStack.empty()) {
                posStack.push(i);
                heightStack.push(arr[i]);
            } else {
                if (heightStack.peek() < arr[i]) {
                    posStack.push(i);
                    heightStack.push(arr[i]);
                } else {
                    int prevPos = posStack.peek();
                    while (!heightStack.empty() && heightStack.peek() > arr[i]) {
                        int prevHeight = heightStack.pop();
                        prevPos = posStack.pop();
                        int width = i - prevPos;
                        int rectSize = prevHeight * width;
                        maxRect = Math.max(rectSize, maxRect);
                    }
                    heightStack.push(arr[i]);
                    posStack.push(prevPos);
                }
            }
        }

        while (!heightStack.empty()) {
            int prevPos = posStack.pop();
            int prevHeight = heightStack.pop();
            int width = (arr.length) - prevPos;
            int rectSize = prevHeight * width;
            maxRect = Math.max(rectSize, maxRect);
        }

        return maxRect;
    }

    public static void run() {
        int[] arr1 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("The largest rect is: " + getLargestRect(arr1));

        int[] arr2 = {1, 1, 1, 2};
        System.out.println("The largest rect is: " + getLargestRect(arr2));

        int[] arr3 = {1, 0, 1, 2};
        System.out.println("The largest rect is: " + getLargestRect(arr3));
    }
}
