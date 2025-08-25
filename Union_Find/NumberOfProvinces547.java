class Solution {
    private static class DSU {

        static int[] rank, parent;

        public static void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return;

            if (rank[pu] > rank[pv])
                parent[pv] = parent[pu];

            else if (rank[pu] < rank[pv])
                parent[pu] = parent[pv];

            else {
                parent[pv] = parent[pu];
                rank[pu]++;
            }
        }

        private static int find(int u) {

            if (u == parent[u])
                return u;

            return parent[u] = find(parent[u]);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int N = isConnected.length;
        DSU.rank = new int[N];
        DSU.parent = new int[N];

        for (int i = 0; i < N; ++i) {
            DSU.parent[i] = i;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {

                if (isConnected[i][j] == 1) {
                    DSU.union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            set.add(DSU.find(i));
        }
        return set.size();
    }
}
