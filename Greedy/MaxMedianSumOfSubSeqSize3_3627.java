class Solution {
    public long maximumMedianSum(int[] nums) {

        long sum = 0;
        Arrays.sort(nums);

        int N = nums.length;

        int i = 0, j = N - 1;

        while (j - i >= 2) {

            sum += nums[j - 1];
            i++;
            j -= 2;
        }

        return sum;
    }
}
