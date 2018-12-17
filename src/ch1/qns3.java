package ch1;

/**
 * URLify:
 * Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string.
 * EXAMPLE
 * Input: "Mr John Smith  ", 13
 * Output: "Mr%20John%20Smith"
 *
 * Time: -
 * Space: -
 */
public class qns3 {

    private static char[] getUrlify(char[] input, int trueLen) {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        boolean isReadingSpace = false;
        for (char c : input) {
            if (curLen >= trueLen) {
                break;
            }
            if (c == ' ') {
                if (!isReadingSpace) {
                    isReadingSpace = true;
                    sb.append("%20");
                    curLen++;
                }
            } else {
                if (isReadingSpace) {
                    isReadingSpace = false;
                }
                sb.append(c);
                curLen++;
            }
        }
        return sb.toString().toCharArray();
    }

    public static void run() {
        System.out.println("=== Running qns 3 ===");
        String input = "Mr    Smith good";
        System.out.println(getUrlify(input.toCharArray(), 13));

        input = "    ";
        System.out.println(getUrlify(input.toCharArray(), 1));

        input = "    M";
        System.out.println(getUrlify(input.toCharArray(), 2));

        input = "    M                                               ";
        System.out.println(getUrlify(input.toCharArray(), 3));

        input = "    M                                               ";
        System.out.println(getUrlify(input.toCharArray(), 2));
        System.out.println("=====================");
    }
}