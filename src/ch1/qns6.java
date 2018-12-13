package ch1;

public class qns6 {

    private static String getCompressedStr(String input) {
        StringBuilder sb = new StringBuilder();
        char curChar = '\0';
        int charCount = 0;
        for (char c : input.toCharArray()) {
            if (curChar != c) {
                if (curChar == '\0') {
                    curChar = c;
                    charCount += 1;
                } else {
                    sb.append(curChar).append(charCount);
                    charCount = 1;
                    curChar = c;
                }
            } else {
                charCount += 1;
            }
        }
        sb.append(curChar).append(charCount);
        String compressedStr = sb.toString();
        if (compressedStr.length() < input.length()) {
            return compressedStr;
        }
        return input;
    }

    public static void run() {
        System.out.println("=== Running ch1.qns6 ===");

        String input = "aa";
        System.out.println(input + " : " + getCompressedStr(input));

        input = "aab";
        System.out.println(input + " : " + getCompressedStr(input));

        input = "aaab";
        System.out.println(input + " : " + getCompressedStr(input));

        input = "aaaabbbbbbcccccc";
        System.out.println(input + " : " + getCompressedStr(input));

        input = "aaaaaabbbbbbcccccccaaaaaabbbb";
        System.out.println(input + " : " + getCompressedStr(input));

        input = "abbbbcccaab";
        System.out.println(input + " : " + getCompressedStr(input));
        System.out.println("====================");
    }
}
