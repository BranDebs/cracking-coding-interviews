package ch5;

public class Qns5_2 {
  private static String binToStr(double num) {
    StringBuilder output = new StringBuilder(32);
    while(output.length() <= 32 && (num % 1 != 0)) {
      num *= 2;
      int ones = (int)num;
      if (ones == 1) {
        output.append("1");
        num -= 1;
      } else {
        output.append("0");
      }
    }
    if (output.length() >= 32) {
      return "ERROR";
    }
    return output.toString();
  }
  public static void tests() {
    print(0.72);
    print(0.5);
    print(0.3);
    print(0.25);
    print(0.15);
    print(0.10);
    print(0.125);
  }

  private static void print(double num) {
    System.out.printf("%s => %s\n", Double.toString(num), binToStr(num));
  }
}
