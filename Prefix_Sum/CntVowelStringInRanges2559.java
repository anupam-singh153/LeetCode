class Solution {

    private HashSet<Character> set = new HashSet<>();

    public boolean isValid(String s) {
        int n = s.length();
        return set.contains(s.charAt(0)) && set.contains(s.charAt(n - 1));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = words.length;
        int[] temp = new int[n + 1];

        for (int i = 0; i < n; ++i) {

            if (isValid(words[i]))
                temp[i + 1] = temp[i] + 1;

            else
                temp[i + 1] = temp[i];

            System.out.print(temp[i] + " ");
        }

        n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            ans[i] = temp[r] - temp[l];
        }
        return ans;
    }
}
