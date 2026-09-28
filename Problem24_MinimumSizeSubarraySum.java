public class Problem24_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println("Minimum length: " + minSubArrayLen(target, nums));
    }

    static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minimum = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minimum = Math.min(minimum, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }
}