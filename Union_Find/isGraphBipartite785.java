import java.util.*;

class Solution {

    private static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int u) {
            if (u != parent[u])
                parent[u] = find(parent[u]);
            return parent[u];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (rank[pu] > rank[pv]) parent[pv] = pu;
            else if (rank[pu] < rank[pv]) parent[pu] = pv;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        DSU dsu = new DSU(n);

        for (int u = 0; u < n; u++) {
            int[] neighbors = graph[u];

            if (neighbors.length == 0) continue;

            int firstNeighbor = neighbors[0];

            for (int v : neighbors) {
                if (dsu.find(u) == dsu.find(v)) {
                    return false; 
                }
                dsu.union(firstNeighbor, v);
            }
        }
        return true;
    }
}
