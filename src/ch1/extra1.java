package ch1;

import java.util.Arrays;

/**
 * Minimize Range
 * You are given an array of n integers (a1, a2, ... , an), and a positive integer k. For every integer in the array,
 * either plus k or minus k so that theYou are given an array of n integers (a1, a2, ... , an), and a positive integer k. For every integer in the array, either plus k or minus k so that the difference between the largest and the smallest integer is minimized in the new array. Return the difference.
 difference between the largest and the smallest integer is minimized in the new array.
 * Return the difference.
 *
 * Time: O(N lg N)
 * Space: O(N)
 */
public class extra1 {

    public static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr); // O(nlgn)
        int n = arr.length;
        int lower = arr[0];
        int upper = arr[n - 1];
        int ans = upper - lower;
        upper = upper - k;
        lower = lower + k;

        if (upper < lower) {
            int temp = lower;
            lower = upper;
            upper = temp;
        }

        for (int i = 1; i < n - 1; i++) {
            int add = arr[i] + k;
            int sub = arr[i] - k;

            if (add <= upper || sub >= lower) {
                continue;
            }

            if (Math.abs(upper - sub) < Math.abs(add - lower)) {
                lower = sub;
            } else {
                upper = add;
            }
        }

        return Math.min(ans, upper - lower);
    }

    public static void run() {
        int arr1[] = {1,4,5,7,11,13,14};
        int k = 3;
        System.out.print("The min diff of array [");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.print("] with k is "+ k +" : ");
        System.out.println(getMinDiff(arr1, k));

        int arr2[] = {1,7,5,3};
        k = 3;
        System.out.print("The min diff of array [ ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.print("] with k is "+ k +" : ");
        System.out.println(getMinDiff(arr2, k));

        int arr3[] = {1,1,1,1};
        k = 3;
        System.out.print("The min diff of array [");
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.print("] with k is "+ k +" : ");
        System.out.println(getMinDiff(arr3, k));

        k = 100;
        System.out.print("The min diff of array [ ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.print("] with k is "+ k +" : ");
        System.out.println(getMinDiff(arr2, k));
    }
}
