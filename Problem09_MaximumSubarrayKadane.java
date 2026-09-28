public class Problem09_MaximumSubarrayKadane {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubarraySum(arr));
    }

    static int maxSubarraySum(int[] arr) {
        int current = arr[0];
        int maximum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            maximum = Math.max(maximum, current);
        }
        return maximum;
    }
}