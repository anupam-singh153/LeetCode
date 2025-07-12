import java.util.*;
import java.io.*;

class CourseScheduleII_210 {

    private List<Integer>[] graph;

    private int[] bfs(int N, int[] inDegree) {

        boolean[] vis = new boolean[N];

        Queue<Integer> queue = new LinkedList<>();

        for (int u = 0; u < N; ++u) {

            if (inDegree[u] == 0)
                queue.add(u);
        }

        int[] result = new int[N];
        int i = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[i++] = u;

            for (int v : graph[u]) {
                inDegree[v]--;

                if (inDegree[v] == 0)
                    queue.add(v);
            }
        }

        if (i == N)
            return result;

        return new int[0];
    }

    public int[] findOrder(int N, int[][] prereqs) {

        graph = new ArrayList[N];

        for (int i = 0; i < N; ++i)
            graph[i] = new ArrayList<>();

        int[] inDegree = new int[N];

        for (int[] pr : prereqs) {
            int v = pr[0];
            int u = pr[1];

            inDegree[v]++;
            graph[u].add(v);
        }

        return bfs(N, inDegree);
    }
}
