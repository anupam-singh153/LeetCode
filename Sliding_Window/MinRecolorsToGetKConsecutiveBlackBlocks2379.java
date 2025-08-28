class Solution {
    public int minimumRecolors(String blocks, int k) {

        int l = 0, r, black = 0;
        int N = blocks.length(), result = 0;

        for (r = 0; r < N; ++r) {

            if (blocks.charAt(r) == 'B')
                black++;

            if (r >= l + k) {
                if (blocks.charAt(l++) == 'B')
                    black--;
            }

            result = Math.max(result, black);
        }

        return k - result;
    }
}
