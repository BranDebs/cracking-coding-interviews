package ch1;

import java.util.Arrays;

/**
 * Find the point where maximum intervals overlap
 * Consider a big party where a log register for guest’s entry and exit times is maintained.
 * Find the time at which there are maximum guests in the party.
 * Note that entries in register are not in any order.
 */
public class extra2 {

    private static int getMaxIntervals(int[] arr, int[] dep) {
        if (arr.length < 1) {
            return -1;
        }

        int maxInterval = 0;
        int curInterval = 0;

        int arrIdx = 0;
        int depIdx = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        while (arrIdx < arr.length && depIdx < dep.length) {
            int curArr = arr[arrIdx];
            if (curArr <= dep[depIdx]) {
                curInterval++;
                if (curInterval > maxInterval) {
                    maxInterval = curInterval;
                }
                arrIdx++;
            } else {
                curInterval--;
                depIdx++;
            }
        }

        return maxInterval;
    }

    public static void run() {
        int arr[] = {1, 2, 10, 5, 5};
        int dep[] = {4, 5, 12, 9, 12};

        System.out.println("The max interval is: " + getMaxIntervals(arr, dep));

    }
}
