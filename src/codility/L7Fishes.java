package codility;

import java.util.Stack;

public class L7Fishes {
    private static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Stack<Integer> fishes = new Stack<Integer>();
        int N = A.length;

        for (int i = 0; i < N; i++) {
            if (fishes.empty()) {
                fishes.push(i);
            } else {
                int prevFish = fishes.peek();
                if (B[i] - B[prevFish] != -1) {
                    fishes.push(i);
                } else {
                    while (B[i] - B[prevFish] == -1 && A[i] > A[prevFish]) {
                        fishes.pop();
                        prevFish = fishes.peek();
                        if (fishes.empty()) {
                            prevFish = i;
                            break;
                        }
                    }
                    if (B[i] - B[prevFish] != -1) {
                        fishes.push(i);
                        continue;
                    }
                }
            }
        }
        return fishes.size();
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        solution(A, B);
    }
}
