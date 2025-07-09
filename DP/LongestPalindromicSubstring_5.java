import java.util.*;
import java.io.*;

class LongestPalindromicSubstring_5 {
    private String[][] dp;

    private String solve(String s, int i, int j) {

        if (i > j)
            return "";

        if (i == j)
            return s.substring(i, j + 1);

        if (!dp[i][j].equals("."))
            return dp[i][j];

        if (isPalindrome(s, i, j))
            return s.substring(i, j + 1);

        String skip_from_st = solve(s, i + 1, j);
        String skip_from_end = solve(s, i, j - 1);

        return dp[i][j] = skip_from_st.length() >= 
                    skip_from_end.length() ? skip_from_st : skip_from_end;
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left += 1;
            right -= 1;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        dp = new String[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], ".");
        }

        return solve(s, 0, n - 1);
    }
}