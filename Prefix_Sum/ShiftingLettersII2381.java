class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();
        int[] letter = new int[n + 1];

        for (int[] shift : shifts) {

            if (shift[2] == 0) {
                letter[shift[0]] += -1;
                letter[shift[1] + 1] += 1;
            } else {
                letter[shift[0]] += 1;
                letter[shift[1] + 1] += -1;
            }
        }

        for (int i = 1; i <= n; ++i) {
            letter[i] += letter[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append((char) ('a' + (s.charAt(i) - 'a' + 26000000 + letter[i]) % 26));
        }

        return sb.toString();
    }
}
