package ch8;

public class Qns8_3 {
    private static boolean magicIndex(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        return helper(arr,0, arr.length - 1);
    }

    private static boolean helper(int[] arr, int start, int end) {
        if (start <= end) {
            int midPt = (start+end) / 2;

            if (midPt == arr[midPt]) {
                return true;
            }
            int leftIdx = Math.min(midPt - 1,  arr[midPt]);
            int rightIdx = Math.max(midPt + 1, arr[midPt]);
            boolean hasLeft = helper(arr,start, leftIdx);
            boolean hasRight = helper(arr,rightIdx, end);

            return hasLeft || hasRight;
        }
        return false;
    }

    public static void tests() {
        int[] test0 = {-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println(magicIndex(test0));

        int[] test1 = {-10,0,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(magicIndex(test1));

        int[] test2 = new int[0];
        System.out.println(magicIndex(test2));
    }
}
