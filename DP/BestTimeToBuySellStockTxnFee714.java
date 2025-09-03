class Solution {

    private int fuck(int[] prices, int i, int canBuy, int fee, int[][] dp) {

        if (i == prices.length)
            return 0;

        if (dp[i][canBuy] != -1)
            return dp[i][canBuy];

        int include = 0;
        if (canBuy == 1)
            include = -prices[i] - fee + fuck(prices, i + 1, 0, fee, dp);
        else
            include = prices[i] + fuck(prices, i + 1, 1, fee, dp);

        int exclude = fuck(prices, i + 1, canBuy, fee, dp);

        return dp[i][canBuy] = Math.max(include, exclude);
    }

    public int maxProfit(int[] prices, int fee) {

        int N = prices.length;
        int[][] dp = new int[N][2];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return fuck(prices, 0, 1, fee, dp);
    }
}
