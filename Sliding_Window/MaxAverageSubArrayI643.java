class Solution {
    public double findMaxAverage(int[] nums, int k) {

        long sum = 0;

        int r = 0;

        while (r < k) {
            sum += nums[r++];
        }

        double result = 1.0 * sum / k;

        while (r < nums.length) {

            sum += nums[r] - nums[r - k];

            double avg = 1.0 * sum / k;
            result = Math.max(avg, result);
            r++;
        }

        return result;
    }
}
