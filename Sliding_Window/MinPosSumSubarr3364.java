class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {

                sum += nums.get(j);
                int idxDiff = j - i + 1;

                if (idxDiff >= l && idxDiff <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
            sum = 0;
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
