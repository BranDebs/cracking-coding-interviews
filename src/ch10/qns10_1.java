package ch10;

import java.util.Arrays;

public class qns10_1 {
  private static int[] sortedMerge(int[] A, int[] B) {
    if (A.length <= 0) {
      throw new IllegalArgumentException();
    }
    int ptrB = B.length-1;
    int ptrA = A.length - B.length -1;
    int i = A.length - 1;
    for (; i >= 0; i--) {
      if (ptrA < 0 || ptrB < 0) {
        break;
      }
      if (A[ptrA] >= B[ptrB]) {
        A[i] = A[ptrA--];
      } else {
        A[i] = B[ptrB--];
      }
    }

    while(ptrA >= 0) {
      A[i--] = A[ptrA--];
    }

    while (ptrB >= 0) {
      A[i--] = B[ptrB--];
    }

    return A;
  }

  public static void tests() {
    int[] A_1_src = {-1,0,3,7,10};
    int[] A_1 = new int[8];
    int[] B_1 = {4,5,8};
    Arrays.fill(A_1, Integer.MAX_VALUE);
    System.arraycopy(A_1_src, 0, A_1,0,5);
    System.out.printf("Ans: ");
    int[] ans_1 = sortedMerge(A_1, B_1);
    for (int i : ans_1) {
      System.out.printf("%d ", i);
    }
    System.out.println();

  }
}
