package ch8;

import java.util.Arrays;

public class qns8_1 {
  // N is the number of steps on a staircase
  private static int tripleStep(int N) {
    if (N < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (N == 0) {
      return 1;
    }
    int[] memo = new int[N+1];
    Arrays.fill(memo, -1);
    return helper(N, memo);
  }

  private static int helper(int stepsLeft, int[] memo) {
    if (stepsLeft < 0) {
      return 0;
    }
    if (stepsLeft == 0) {
      return 1;
    }
    if (memo[stepsLeft] == -1) {
      memo[stepsLeft] = helper(stepsLeft - 1, memo)
          + helper(stepsLeft - 2, memo) + helper(stepsLeft - 3, memo);
    }
    return memo[stepsLeft];
  }
  // [-1, 1, 2,  4]
  public static void tests() {
    // N = 3
    // 1 + 1 + 1 + 1 = 4
    System.out.printf("Give N: %d Ans: %d\n", 3, tripleStep(3));
    System.out.printf("Give N: %d Ans: %d\n", 0, tripleStep(0));
//    System.out.printf("Give N: %d Ans: %d\n", -1, tripleStep(-1));
    System.out.printf("Give N: %d Ans: %d\n", 5, tripleStep(5));
    System.out.printf("Give N: %d Ans: %d\n", 37, tripleStep(37));
  }
}
