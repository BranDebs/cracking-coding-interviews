package ch5;

import java.util.ArrayList;

public class Qns5_3 {
  private static int flipBitToWin(int input) {
    String s = Integer.toBinaryString(input);
    int cnt = 0;
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        al.add(cnt);
        cnt = 0;
      } else {
        cnt += 1;
      }
    }
    if (cnt != 0) {
      al.add(cnt);
    }
    int output = al.get(0) + 1;
    for (int i = 1; i < al.size(); i++) {
      int sum = al.get(i-1) + al.get(i) + 1;
      output = Math.max(sum, output);
    }
    return output;
  }
  public static void tests() {
    int test1 = 1775;
    printHelper(test1, flipBitToWin(test1));

    int test2 = 1729;
    printHelper(test2, flipBitToWin(test2));

    int test3 = 0;
    printHelper(test3, flipBitToWin(test3));

    int test4 = 7;
    printHelper(test4, flipBitToWin(test4));

    int test5 = 2;
    printHelper(test5, flipBitToWin(test5));

    int test6 = 5;
    printHelper(test6, flipBitToWin(test6));
  }

  private static void printHelper(int input, int output) {
    String s = Integer.toBinaryString(input);
    System.out.printf("Input %s Output %d\n", s, output);
  }
}
