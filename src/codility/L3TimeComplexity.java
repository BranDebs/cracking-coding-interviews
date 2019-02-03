package codility;

/**
 * You are given an integer n. Count the total of 1 + 2 + ... + n.
 */
public class L3TimeComplexity {

    private static int getSumOneTillN(int n) {
        int sum = ((n + 1) * n) / 2;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 1 till 5: " + getSumOneTillN(5));
        System.out.println("Sum of 1 till 20: " + getSumOneTillN(20));
    }
}
