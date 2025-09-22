class Solution {

    private String[][] dp;

    private String solve(char[] number, int idx, int k) {

        if (idx == number.length)
            return k == 0 ? "" : "~";

        if (dp[idx][k] != null)
            return dp[idx][k];

        //include digit into number
        String include = number[idx] + "" + solve(number, idx + 1, k);

        //exclude
        String exclude = "~";

        if (k > 0)
            exclude = solve(number, idx + 1, k - 1);

        return dp[idx][k] = include.compareTo(exclude) < 0 ? include : exclude;
    }

    public String removeKdigits(String num, int k) {

        int n = num.length();
        dp = new String[n][k + 1];

        String ans = solve(num.toCharArray(), 0, k);
        int i = 0;

        while (i < ans.length() && ans.charAt(i) == '0')
            i++;

        return ans.substring(i).isEmpty() ? "0" : ans.substring(i);
    }
}
