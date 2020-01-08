package ch1;

public class Qns1_3 {
  private static char[] urlify(char[] raw, int trueLen) {
    if (raw.length < trueLen || trueLen < 1) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int startWordIdx = -1;
    for (int i = 0; i < raw.length; i++) {
      if (raw[i] != ' ') {
        startWordIdx = i;
        break;
      }
    }
    if (startWordIdx == -1) {
      return null;
    }

    boolean hasSpace = false;
    int actualIdx = 0;
    int spaceCnt = 0;
    for (int i = startWordIdx; i < raw.length && actualIdx < trueLen; i++) {
      if (raw[i] != ' ') {
        hasSpace = false;
        raw[actualIdx] = raw[i];
        actualIdx+=1;
      } else {
        if (!hasSpace) {
          raw[actualIdx] = raw[i];
          actualIdx+=1;
          spaceCnt+=1;
        }
        hasSpace = true;
      }
    }

    int endIdx = (trueLen-1) + (spaceCnt * 3) - spaceCnt;
    for (int i = trueLen-1; i >= 0; i--) {
      if (raw[i] != ' ') {
        raw[endIdx] = raw[i];
        endIdx--;
      } else {
        raw[endIdx] = '0';
        raw[endIdx-1] = '2';
        raw[endIdx-2] = '%';
        endIdx -= 3;
      }

    }
    return raw;
  }

  public static void tests() {
    String words1 = "Mr John     Smith      ";
    printHelper(words1.toCharArray(), urlify(words1.toCharArray(), 13), 17);

    String words2 = "         Mr         John     Smith      ";
    printHelper(words2.toCharArray(), urlify(words2.toCharArray(), 13), 17);

    String words3 = "MrJohnSmith";
    printHelper(words3.toCharArray(), urlify(words3.toCharArray(), 11), 11);

    String words4 = "Mr             ";
    printHelper(words4.toCharArray(), urlify(words4.toCharArray(), 2), 2);
  }

  private static void printHelper(char[] raw, char[] out, int trueLen) {
    String rawStr = String.copyValueOf(raw);
    String outStr = String.copyValueOf(out);

    System.out.printf("\"%s\", \"%s\"\n", rawStr, outStr.substring(0, trueLen));
  }
}
