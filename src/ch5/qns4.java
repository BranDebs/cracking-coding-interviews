package ch5;

/**
 * Next Number
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 *
 * Time:
 * Space:
 */
public class qns4 {

    public static int[] nextNumber(int n) {
        int[] output = {n, n};
        String binStr = Integer.toBinaryString(n);
        // padding with zeros in front
        int padLen = 32 - binStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padLen; i++) {
            sb.append("0");
        }
        sb.append(binStr);
        binStr = sb.toString();
        int lowestPt = -1;
        int prevLowestpt = -1;
        for (int i = 0 ; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                if (lowestPt != -1) {
                    prevLowestpt = lowestPt;
                }
                lowestPt = i;
            }
        }

        if (lowestPt == binStr.length() - 1) {
            output[0] = n;
        } else {
            char[] lowestStr = binStr.toCharArray();
            lowestStr[lowestPt] = '0';
            lowestStr[lowestPt+1] = '1';
            output[0] = Integer.parseInt(new String(lowestStr), 2);
        }

        int ptCounter = lowestPt;
        char[] highestStr = binStr.toCharArray();
        int highestPt = lowestPt - 1;
        while (highestPt >= 0) {
            if (highestStr[highestPt] == '0') {
                highestStr[highestPt] = '1';
                highestStr[highestPt + 1] = '0';
                output[1] = Integer.parseInt(new String(highestStr), 2);
                break;
            }
            highestPt -= 1;
        }

        return output;
    }
    public static void run() {
        int n = 5;
        int lowest, highest;
        int[] output = nextNumber(n);
        lowest = output[0];
        highest = output[1];
        System.out.println("Given the integer: " + n + " the lowest is: " + lowest + " the highest is: " + highest);

        n = 7;
        output = nextNumber(n);
        lowest = output[0];
        highest = output[1];
        System.out.println("Given the integer: " + n + " the lowest is: " + lowest + " the highest is: " + highest);
    }
}
