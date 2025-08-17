class Solution {

    // optimized approach 
    public int waysToSplitArray(int[] nums) {

        long totSum = 0;

        for (int x : nums)
            totSum += x;

        long prefixSum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length - 1; ++i) {

            prefixSum += nums[i];

            if (prefixSum >= totSum - prefixSum)
                ans++;
        }
        return ans;
    }
}
