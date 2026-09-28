import java.util.*;

public class Problem22_MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int n = 6;

        System.out.println("Missing number: " + findMissing(arr, n));
    }

    // Assumption from the problem: numbers are from 1 to n, with one missing.
    static int findMissing(int[] arr, int n) {
        long expected = (long) n * (n + 1) / 2;
        long actual = 0;

        for (int value : arr) {
            actual += value;
        }
        return (int) (expected - actual);
    }
}