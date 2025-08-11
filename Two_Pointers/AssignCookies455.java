class Solution {
    public int findContentChildren(int[] greed, int[] s) {

        Arrays.sort(greed);
        Arrays.sort(s);

        int greedIdx = 0;
        int sIdx = 0;

        while (greedIdx < greed.length && sIdx < s.length) {

            if (s[sIdx] >= greed[greedIdx]) {
                greedIdx++;
            }
            sIdx++;
        }
        return greedIdx;
    }
}
