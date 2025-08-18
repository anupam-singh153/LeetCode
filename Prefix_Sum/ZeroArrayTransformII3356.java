class Solution {

    public boolean isPossible(int k, int[][] queries, int[] nums) {

        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < k; ++i) {

            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            prefixSum[l] += val;
            prefixSum[r + 1] -= val;
        }

        for (int i = 1; i <= n; ++i) {
            prefixSum[i] += prefixSum[i - 1];
        }

        for (int i = 0; i < n; ++i) {

            if (prefixSum[i] < nums[i])
                return false;
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {

        int ans = -1;
        int low = 0, high = queries.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, queries, nums)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
