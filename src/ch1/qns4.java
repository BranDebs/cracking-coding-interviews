package ch1;

import java.util.Hashtable;

/**
 * Palindrome Permutation:
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 *
 * Time: -
 * Space: -
 */
public class qns4 {

    private static boolean isPalindromePermute(String input) {
        input = input.toLowerCase();
        Hashtable<Character, Integer> wordFreqMap = new Hashtable<>();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (wordFreqMap.containsKey(c)) {
                int count = wordFreqMap.get(c) + 1;
                wordFreqMap.put(c, count);
                continue;
            }
            wordFreqMap.put(c, 1);
        }

        int oddCount = 0;
        for (char key : wordFreqMap.keySet()) {
            int freqCount = wordFreqMap.get(key);
            if (freqCount % 2 != 0) {
                oddCount += 1;
            }
        }

        if (oddCount > 1) {
            return false;
        }

        return true;
    }

    public static void run() {
        System.out.println("=== Running ch1.qns4 ===");
        String input = "ac a";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "ca caca";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "Mana M Ana";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "Tact Coa";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "A a";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "A A a";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "A A b";
        System.out.println(input + " : " + isPalindromePermute(input));

        input = "aca aca aca";
        System.out.println(input + " : " + isPalindromePermute(input));

        System.out.println("====================");
    }
}
