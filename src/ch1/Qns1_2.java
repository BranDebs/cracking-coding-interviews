package ch1;

import java.util.HashMap;

public class Qns1_2 {
  private static boolean checkPermutations(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    HashMap<Character, Integer> charFreqs = new HashMap<Character, Integer>();
    for (char c : A.toCharArray()) {
      if (charFreqs.containsKey(c)) {
        int count = charFreqs.get(c);
        charFreqs.put(c, count + 1);
        continue;
      }
      charFreqs.put(c, 1);
    }

    for (char c: B.toCharArray()) {
      if (charFreqs.containsKey(c)) {
        int count = charFreqs.get(c);
        if (count <= 0) {
          return false;
        }
        charFreqs.put(c, count - 1);
        continue;
      }
      return false;
    }

    return true;
  }

  public static void tests() {
    String A_1 = "abcd", B_1 = "abc";
    System.out.printf("A: %s B: %s permutation: %B\n", A_1, B_1, checkPermutations(A_1, B_1));

    String A_2 = "happy", B_2 = "happyy";
    System.out.printf("A: %s B: %s permutation: %B\n", A_2, B_2, checkPermutations(A_2, B_2));
    System.out.printf("A: %s B: %s permutation: %B\n", B_2, A_2, checkPermutations(B_2, A_2));

    String A_3 = "happy", B_3 = "apphy";
    System.out.printf("A: %s B: %s permutation: %B\n", A_3, B_3, checkPermutations(A_3, B_3));

    String A_4 = "happp", B_4 = "apppy";
    System.out.printf("A: %s B: %s permutation: %B\n", A_4, B_4, checkPermutations(A_4, B_4));

    String A_5 = "", B_5 = "";
    System.out.printf("A: %s B: %s permutation: %B\n", A_5, B_5, checkPermutations(A_5, B_5));
  }
}
