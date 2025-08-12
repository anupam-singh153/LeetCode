class Solution {

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder();

        int n = s.length();
        int idx = 0;

        while (idx < n) {

            int j = Math.min(idx + k, n);

            if ((idx / k) % 2 == 0) {

                str.append(reverse(s.substring(idx, j)));
            } else {

                str.append(s.substring(idx, j));
            }

            idx += k;
        }

        return str.toString();
    }
}
