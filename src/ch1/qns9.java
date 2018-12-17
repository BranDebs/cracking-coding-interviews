package ch1;

import java.util.Hashtable;

/**
 * String Rotation:
 * Assume you have a method isSubst ring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
 * one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 *
 * Time: O(N)
 * Space: O(N)
 */

public class qns9 {

    public static void run() {
        String test1a = "watermelon";
        String test1b = "lonwaterme";
        boolean ans = isSubstring(test1a, test1b);
        System.out.println(ans);

        test1a = "wwweww";
        test1b = "wewwww";
        ans = isSubstring(test1a, test1b);
        System.out.println(ans);

        test1a = "ttee";
        test1b = "tete";
        ans = isSubstring(test1a, test1b);
        System.out.println(ans);

        test1a = "watermelon";
        test1b = "nolwaterme";
        ans = isSubstring(test1a, test1b);
        System.out.println(ans);
    }

    public static boolean isSubstring(String test1a, String test1b) {
        Hashtable<Character,Integer> charCountMap = new Hashtable<>();
        if(test1a.length() != test1b.length() || test1a == null) {
            return false;
        }
        for (int i=0; i<test1a.length(); i++) {
            if (!charCountMap.containsKey(test1a.charAt(i))) {
                charCountMap.put(test1a.charAt(i), 1);
            }
            else {
                charCountMap.put(test1a.charAt(i), charCountMap.get(test1a.charAt(i)) + 1);
            }
        }

        char mostUniqueKey = '\0';
        int smallestKeyFreq = test1a.length() + 1;
        for (char c : charCountMap.keySet()) {
            int wordFreq = charCountMap.get(c);
            if (wordFreq < smallestKeyFreq) {
                mostUniqueKey = c;
                smallestKeyFreq = wordFreq;
            }
        }
        int startingIdxS1 = 0;
        int startingIdxS2 = 0;
        for (int idx = 0; idx < test1b.length(); idx++) {
            if (test1b.charAt(idx) == mostUniqueKey) {
                startingIdxS2 = idx;
            }
            if (test1a.charAt(idx) == mostUniqueKey) {
                startingIdxS1 = idx;
            }
        }

        for (int i = 0; i < test1a.length(); i++) {
            int idxS1 = (startingIdxS1 + i) % test1a.length();
            int idxS2 = (startingIdxS2 + i) % test1b.length();
            if (test1a.charAt(idxS1) != test1b.charAt(idxS2)) {
                return false;
            }
        }

        return true;
    }
}
