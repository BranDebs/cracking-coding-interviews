package ch5;

/**
 * Conversion
 * Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 *
 * Time: O(N)
 * Space: O(1)
 */
public class qns6 {

    private static int getConversion(int from, int to) {
        String fromBinStr = Integer.toBinaryString(from);
        String toBinStr = Integer.toBinaryString(to);

        fromBinStr = getPaddedBinStr(fromBinStr);
        toBinStr = getPaddedBinStr(toBinStr);

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (fromBinStr.charAt(i) != toBinStr.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static String getPaddedBinStr(String binStr) {
        StringBuilder sb = new StringBuilder();
        int padLen = 32 - binStr.length();
        for (int i = 0; i < padLen; i++) {
            sb.append('0');
        }
        sb.append(binStr);
        return sb.toString();
    }

    public static void run() {
        int from, to, count;

        from = 29;
        to = 15;
        count = getConversion(from, to);
        System.out.println("The num of bits to flip from " + from + " to " + to + " is: " + count);

        from = 2;
        to = 5;
        count = getConversion(from, to);
        System.out.println("The num of bits to flip from " + from + " to " + to + " is: " + count);

        from = 10;
        to = 5;
        count = getConversion(from, to);
        System.out.println("The num of bits to flip from " + from + " to " + to + " is: " + count);
    }

}
