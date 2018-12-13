package ch1;

import java.util.Hashtable;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class qns2 {

    /**
     * Assume thatt a and b will be the same size
     * @param a
     * @param b
     */
    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Hashtable<Character, Integer> wordFreqMap = new Hashtable<Character, Integer>();
        for (char c : a.toCharArray()) {
            if (wordFreqMap.containsKey(c)) {
                int count = wordFreqMap.get(c) + 1;
                wordFreqMap.put(c, count);
                continue;
            }
            wordFreqMap.put(c, 1);
        }
        for (char c: b.toCharArray()) {
            if (wordFreqMap.containsKey(c)) {
                int count = wordFreqMap.get(c) - 1;
                if (count < 0) {
                    return false;
                }
                wordFreqMap.put(c, count);
            } else {
                return false;
            }
        }
        return true;
    }

    private static void getAns(String a, String b, boolean isPermute) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" is");
        if (isPermute) {
            sb.append(" permute of ");
        } else {
            sb.append(" is not permute of ");
        }
        sb.append(b);
        System.out.println(sb.toString());
    }

    public static void run() {
        System.out.println("=== Running ch1.qns2 ===");
        String a, b;
        a = "abc";
        b = "acb";
        getAns(a,b,checkPermutation(a,b));

        a = "abc";
        b = "acbd";
        getAns(a,b,checkPermutation(a,b));

        a = "abce";
        b = "acbd";
        getAns(a,b,checkPermutation(a,b));

        a = "";
        b = "acbd";
        getAns(a,b,checkPermutation(a,b));
        System.out.println("====================");
    }
}
