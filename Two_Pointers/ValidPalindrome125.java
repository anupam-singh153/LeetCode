class Solution {

    public boolean isAlpha(char ch) {

        return ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }

    public boolean isPalindrome(String s) {

        int n = s.length();
        int l = 0, r = n - 1;
        s = s.toLowerCase();

        while (l < r) {

            while (l < n && !isAlpha(s.charAt(l)))
                l += 1;

            while (r >= 0 && !isAlpha(s.charAt(r)))
                r -= 1;

            if (l < r && s.charAt(l) != s.charAt(r))
                return false;

            l += 1;
            r -= 1;
        }

        return true;
    }
}
