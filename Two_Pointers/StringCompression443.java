class Solution {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder("");
        int n = chars.length;
        int index = 0;

        for (int i = 0; i < n;) {
            char ch = chars[i];
            int count = 1;

            while (i < n - 1 && chars[i + 1] == chars[i]) {
                count++;
                i++;
            }

            chars[index++] = ch;

            if (count > 1) {
                char[] countChars = Integer.toString(count).toCharArray();
                for (char c : countChars) {
                    chars[index++] = c;
                }
            }

            i++;
        }

        return index;
    }
}
