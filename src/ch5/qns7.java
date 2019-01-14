package ch5;

/**
 * Pairwise Swap
 * Write a program to swap odd and even bits in an integer with as few instructions as
 * possible (e.g., bit 13 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 *
 * Time:
 * Space:
 */
public class qns7 {

    private static int getPairwiseSwap(int n) {
        int lastBitMask = n >> 31 & 1;
        int newSwappedNum = n << 1;
        return newSwappedNum | lastBitMask;
    }

    public static void run() {
        int n = 1;
        int output = getPairwiseSwap(n);

        System.out.println("Given n: " + n + " after swapping: " + output);

        n = 5;
        output = getPairwiseSwap(n);
        System.out.println("Given n: " + n + " after swapping: " + output);

        n = -10;
        output = getPairwiseSwap(n);
        System.out.println("Given n: " + n + " after swapping: " + output);

    }
}
