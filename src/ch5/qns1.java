package ch5;

import utils.Bitwise.BitwiseUtil;

/**
 * Insertion
 * You are given two 32-bit numbers, N and M, and two bit positions, i and
 * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 */
public class qns1 {

    private static int getInsertionFromItoJ(int n, int m, int i, int j) {
        for (int itr = i; itr <= j; itr++) {
            n = BitwiseUtil.setBit(n, itr);
        }
        int mMask = (~0 << (j + 1)) | (m << i) | ((1 << i) - 1);
        return n & mMask;
    }

    public static void run() {
        int n = 8;
        int m = 1;
        int i = 1;
        int j = 2;
        int ans = getInsertionFromItoJ(n, m, i, j);
        System.out.println("Given n: " + n + " m: " + m + " i: " + i + " j: " + j + " the ans is: " + ans);

        n = 12;
        ans = getInsertionFromItoJ(n, m, i, j);
        System.out.println("Given n: " + n + " m: " + m + " i: " + i + " j: " + j + " the ans is: " + ans);
    }
}
