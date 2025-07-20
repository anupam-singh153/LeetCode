class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int[] t : trust) {

            inDegree[t[1]]++;
            outDegree[t[0]]--;
        }

        for (int i = 1; i <= N; ++i) {

            if (inDegree[i] == N - 1 && outDegree[i] == 0)
                return i;
        }

        return -1;
    }
}
