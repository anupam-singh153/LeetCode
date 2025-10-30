class Solution {

    private int binSearch(int[][] events, int l, int r, int target) {

        int result = events.length;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (events[m][0] > target) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return result;
    }

    private int solve(int[][] events, int k, int idx, int[][] dp) {

        if (idx == events.length || k == 0)
            return 0;

        if (dp[idx][k] != -1)
            return dp[idx][k];

        int skip = solve(events, k, idx + 1, dp);

        int getIdx = binSearch(events, idx + 1, events.length - 1, events[idx][1]);
        int include = events[idx][2] + solve(events, k - 1, getIdx, dp);

        return dp[idx][k] = Math.max(skip, include);
    }

    public int maxValue(int[][] events, int k) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] dp = new int[events.length + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(events, k, 0, dp);
    }
}
