class Solution {
    private static final int INF = (int) 1e9;
    private int[][] dp;

    private int solve(char[] word, int i, int prevIndex) {
        if (i == word.length) return 0;
        if (dp[i][prevIndex] != -1) return dp[i][prevIndex];

        int ans = INF;

        // Option 1: Keep current char if valid
        if (prevIndex == 26 || Math.abs(word[i] - ('a' + prevIndex)) > 1) {
            ans = Math.min(ans, solve(word, i + 1, word[i] - 'a'));
        }

        // Option 2: Replace current char with something valid
        for (char c = 'a'; c <= 'z'; c++) {
            if (prevIndex == 26 || Math.abs(c - ('a' + prevIndex)) > 1) {
                ans = Math.min(ans, 1 + solve(word, i + 1, c - 'a'));
            }
        }

        return dp[i][prevIndex] = ans;
    }

    public int removeAlmostEqualCharacters(String word) {
        char[] arr = word.toCharArray();
        dp = new int[arr.length][27];
        
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);
        
        return solve(arr, 0, 26); 
    }
}
