class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;

        int[] prefix = new int[N];
        int[] suffix = new int[N];

        int one = -N;
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1)
                one = i;
            prefix[i] = one;
        }

        one = 2 * N;
        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1)
                one = i;
            suffix[i] = one;
        }

        int result = 0;
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 0) {
                int distLeft = i - prefix[i];
                int distRight = suffix[i] - i;
                result = Math.max(result, Math.min(distLeft, distRight));
            }
        }

        return result;
    }
}
