class Solution {
    public int countPartitions(int[] nums) {

        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; ++i) {
            rightSum += nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {

            leftSum += nums[i];
            rightSum -= nums[i];

            if ((leftSum - rightSum) % 2 == 0)
                ans++;
        }

        return ans;
    }
}
