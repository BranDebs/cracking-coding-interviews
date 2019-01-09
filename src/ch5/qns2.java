package ch5;

/**
 * Binary to String
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
 * the binary representation. If the number cannot be represented accurately in binary with at most 32
 * characters, print "ERROR:'
 */
public class qns2 {
    private static String binToStr(double n) {
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(".");
        while (sb.length() < 32) {
            n *= 2;
            if (n >= 1) {
                n -= 1;
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        if (n != 0) {
            return "Error";
        }
        return sb.toString();
    }

    public static void run() {
        double n = 0.5;
        String output = binToStr(n);
        System.out.println("Given the number n: " + n + " the string repr is: " + output);

        n = 0.25;
        output = binToStr(n);
        System.out.println("Given the number n: " + n + " the string repr is: " + output);

        n = 0.72;
        output = binToStr(n);
        System.out.println("Given the number n: " + n + " the string repr is: " + output);
    }
}
