package ch1;

/**
 * One Away:
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 * Time: -
 * Space: -
 */
public class qns5 {

    private static boolean isOneAway(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int diff = Math.abs(aLen - bLen);
        if (diff > 1) {
            return false;
        }
        if (diff == 1) {
            String longest, smallest;
            if (aLen > bLen) {
                smallest = b;
                longest = a;
            } else {
                smallest = a;
                longest = b;
            }
            for (int i = 0; i < smallest.length(); i++) {
                if (smallest.charAt(i) != longest.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        int countAway = 0;
        if (diff == 0) {
            for (int i = 0; i < aLen; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    countAway += 1;
                    if (countAway > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void run() {
        System.out.println("=== Running ch1.qns5 ===");

        String a = "pale", b = "ple";
        System.out.println(a + ", " + b + " " + isOneAway(a, b));

        a = "pale"; b = "pl";
        System.out.println(a + ", " + b + "  "+ isOneAway(a, b));

        a = "pale"; b = "";
        System.out.println(a + ", " + b + "  "+ isOneAway(a, b));

        a = "pale"; b = "bale";
        System.out.println(a + ", " + b + "  "+ isOneAway(a, b));

        a = "pake"; b = "bale";
        System.out.println(a + ", " + b + "  "+ isOneAway(a, b));

        a = "pakek"; b = "bale";
        System.out.println(a + ", " + b + "  "+ isOneAway(a, b));
        System.out.println("====================");
    }
}
