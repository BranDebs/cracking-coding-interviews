package ch8;

/**
 * Triple Step
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class qns1 {

    private static int getNumSteps(int n, int step, int[] arr) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (arr[n] == 0) {
            arr[n] = getNumSteps(n-1, 1, arr) + getNumSteps(n-2, 2, arr) + getNumSteps(n - 3, 3, arr);
        }

        return arr[n];
    }

    public static void run() {
        int n = 2;
        int[] arr = new int[n + 1];
        System.out.println("Given n: " + n + " num of steps: " + getNumSteps(n, 0, arr));

        n = 3;
        arr = new int[n + 1];
        System.out.println("Given n: " + n + " num of steps: " + getNumSteps(n, 0, arr));

        n = 10;
        arr = new int[n + 1];
        System.out.println("Given n: " + n + " num of steps: " + getNumSteps(n, 0, arr));
    }
}
