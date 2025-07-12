import java.util.*;
import java.io.*;

class CourseSchedule_207 {

    private List<Integer>[] graph;

    private boolean isCycle(int u, boolean[] vis, boolean[] rec){

        vis[u] = true;
        rec[u] = true;

        for(int v : graph[u]){

            if(rec[v])
                return true;

            if(!vis[v] && isCycle(v, vis, rec))
                return true;
        }

        rec[u] = false;
        return false;
    }
    public boolean canFinish(int N, int[][] prereqs) {
        
        graph = new ArrayList[N];

        for(int i = 0; i < N; ++i)
            graph[i] = new ArrayList<>();

        for(int[] pr : prereqs){
            int v = pr[0];
            int u = pr[1];

            graph[u].add(v);
        }

        boolean[] vis = new boolean[N];
        boolean[] rec = new boolean[N];

        for(int u = 0; u < N; ++u){

            if(!vis[u] && isCycle(u, vis, rec))
                return false;
        }

        return true;
    }
}
