package ch1;

import java.util.HashSet;

/**
 *  Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * */
public class qns1 {

    /**
    * Assuuming ASCII - 128 characters -> 7 buts
    */
    private static boolean findUnique(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() > 128) {
            return false;
        }
        boolean[] uniqueMap = new boolean[128];
        for (char c : s.toCharArray()) {
            int asciiVal = (int)c;
            if (uniqueMap[asciiVal]) {
                return false;
            }
            uniqueMap[asciiVal] = true;
        }
        return true;
    }

    public static void run() {
        System.out.println("=== Running qns 1 ===");
        String input = "hello";
        outputAns(input, findUnique(input));

        input = "";
        outputAns(input, findUnique(input));

        input = "abcd";
        outputAns(input, findUnique(input));

        input = null;
        outputAns(input, findUnique(input));
        System.out.println("====================");
    }

    private static void outputAns(String s, boolean unique) {
        StringBuilder sb = new StringBuilder();
        sb.append(s).append(" is");
        if (unique) {
            sb.append(" unique!");
        } else {
            sb.append(" not unique!");
        }
        System.out.println(sb.toString());
    }
}
