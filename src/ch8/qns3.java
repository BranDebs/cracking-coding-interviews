package ch8;

/**
 * Magic Index
 * A magic index in an array A [e ... n -1] is defined to be an index such that A[ i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class qns3 {

    private static boolean hasMagicIndex(int[] arr) {
        return hasMagicIndex(arr, 0, arr.length - 1);
    }

    private static boolean hasMagicIndex(int[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        int midPt = (start + end) / 2;
        if (arr[midPt] == midPt) {
            return true;
        }
        int leftIdx = Math.min(midPt - 1, arr[midPt]);
        if (hasMagicIndex(arr, start, leftIdx)) {
            return true;
        }
        int rightIdx = Math.max(midPt + 1, arr[midPt]);
        return hasMagicIndex(arr, rightIdx, end);
    }

    public static void run() {
        int[] arr1 = {0,1,4,8,10};
        System.out.println("Given the array there is magic index: " + hasMagicIndex(arr1));

        int[] arr2 = {5,4,3,2,1};
        System.out.println("given the array there is magic index: " + hasMagicIndex(arr2));

        int[] arr3 = {0,0,4,8,10};
        System.out.println("given the array there is magic index: " + hasMagicIndex(arr3));

        int[] arr4 = {1,1,4,8,10};
        System.out.println("given the array there is magic index: " + hasMagicIndex(arr4));
    }
}
