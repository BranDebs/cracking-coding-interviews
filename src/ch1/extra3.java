package ch1;

/**
 * Largest Sum Contiguous Subarray
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class extra3 {

    public static int getLargestSumInArr(int arr[]) {
        if (arr.length < 0) {
            return -1;
        }

        int largestSum = arr[0];
        int curSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            largestSum = Math.max(largestSum, curSum);
        }

        return largestSum;
    }

    public static void run() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("The largest array in subarray is: " + getLargestSumInArr(arr));

        int[] arr1 = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println("The largest array in subarray is: " + getLargestSumInArr(arr1));
    }
}
