package ch5;

/**
 * Flip Bit to Win
 * You have an integer and you can flip exactly one bit from a 13 to a 1. Write code to
 * find the length of the longest sequence of ls you could create.
 *
 * Time: O(N)
 * Space O(N)
 */
public class qns3 {
    private static int bitToWin(int n) {
        String binStr = Integer.toBinaryString(n);
        boolean isZero = false;
        int maxCount = 0;
        int count = 0;
        int numOnesBeforeZero = 0;
        for (char c : binStr.toCharArray()) {
            if (c == '0') {
                if (isZero == false) {
                    isZero = true;
                    numOnesBeforeZero++;
                    count++;
                } else {
                    isZero = false;
                    count = count - numOnesBeforeZero ;
                    numOnesBeforeZero = ++count;
                }
            } else if (c == '1'){
                if (isZero == false) {
                    numOnesBeforeZero += 1;
                }
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
    public static void run() {
        int n = 1775;
        int output = bitToWin(n);
        System.out.println("Given the num: " + n + " the bit to win is: " + output);

        n = 10;
        output = bitToWin(n);
        System.out.println("Given the num: " + n + " the bit to win is: " + output);

        n = 0;
        output = bitToWin(n);
        System.out.println("Given the num: " + n + " the bit to win is: " + output);

        n = 442;
        output = bitToWin(n);
        System.out.println("Given the num: " + n + " the bit to win is: " + output);
    }
}
