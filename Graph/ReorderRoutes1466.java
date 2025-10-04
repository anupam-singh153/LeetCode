class Solution {

    private int dfs(List<Integer>[] graph, int from, boolean[] vis) {

        vis[from] = true;

        int change = 0;

        for (int to : graph[from]) {

            if (!vis[Math.abs(to)])
                change += dfs(graph, Math.abs(to), vis) + (to > 0 ? 1 : 0);
        }

        return change;
    }

    public int minReorder(int n, int[][] connections) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] conn : connections) {

            int u = conn[0];
            int v = conn[1];

            graph[u].add(v);
            graph[v].add(-u);
        }

        return dfs(graph, 0, new boolean[n]);
    }
}
