package ch5;

public class qns5_1 {
  private static int solution(int N, int M, int i, int j) {

    System.out.printf("N %s\nM %s\n", Integer.toBinaryString(N), Integer.toBinaryString(M));
    int size = j - i + 1;
    int mask = (~0 >>> (32-size)) << i;
    System.out.printf("Mask %s\n", Integer.toBinaryString(mask));
    int newN = N | mask;
    System.out.printf("newN %s\n", Integer.toBinaryString(newN));
    int finalMask = (~0 << (j+1)) | (~0 & (M << i)) | (~0 >>> 32 - i);
    System.out.printf("finalMask %s\n", Integer.toBinaryString(finalMask));

    return newN & finalMask;
  }

  public static void tests() {
    /*
    N = 1010
    M = 11
    ANS = 1110; givne i = 1 j = 2

    mask = 0 10
     */
    System.out.printf("Ans: %s\n", Integer.toBinaryString(solution(10, 3, 1, 2)));
    System.out.printf("Ans: %s\n", Integer.toBinaryString(solution(1024, 19, 2, 6)));
    System.out.printf("Ans: %s\n", Integer.toBinaryString(solution(1040, 19, 2, 6)));
  }
}
