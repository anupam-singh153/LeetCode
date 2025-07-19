class Solution {

    static class Edge implements Comparable<Edge> {
        int s, d, w;

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    private int[] rank, parent;

    private void union(int u, int v) {

        int pU = find(u);
        int pV = find(v);

        if (pU == pV)
            return;

        if (rank[pU] > rank[pV])
            parent[pV] = pU;

        else if (rank[pU] < rank[pV])
            parent[pU] = pV;

        else {
            parent[pV] = pU;
            rank[pU]++;
        }
    }

    private int find(int u) {

        if (u == parent[u])
            return u;

        return parent[u] = find(parent[u]);
    }

    private int krushkals(List<Edge> edges) {
        int sum = 0;

        for (Edge e : edges) {
            int u = e.s;
            int v = e.d;
            int w = e.w;

            int pU = find(u);
            int pV = find(v);

            if (pU != pV) {
                union(pU, pV);
                sum += w;
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {

        int N = points.length;
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {

                int x1 = points[i][0];
                int x2 = points[j][0];

                int y1 = points[i][1];
                int y2 = points[j][1];

                int c = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new Edge(i, j, c));
            }
        }

        parent = new int[N];
        rank = new int[N];

        for (int i = 0; i < N; ++i)
            parent[i] = i;

        Collections.sort(edges);

        return krushkals(edges);
    }
}
