package ch1;

public class Qns1_1 {
  public static boolean isUnique(String input) {
    // Assuming 26 english characters
    int[] charCounts = new int[256];
    for(char c : input.toCharArray()) {
      int charVal = (int)c;
      if (charVal >= 256) {
        throw new IndexOutOfBoundsException();
      }
      charCounts[charVal]++;
    }
    for (int i = 0; i < 256; i++) {
      if (charCounts[i] > 1) {
        return false;
      }
    }
    return true;
  }

  public static void tests() {
    String empty = "";
    System.out.println(isUnique(empty));

    String unique = "abcdef!kl.mn9";
    System.out.println(isUnique(unique));

    String duplicate = "bcdaark";
    System.out.println(isUnique(duplicate));
  }
}
