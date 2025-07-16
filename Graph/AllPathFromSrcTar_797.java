import java.util.*;
import java.io.*;

class AllPathFromSrcTar_797 {

    private void dfs(int[][] graph, boolean[] vis, int curr, int dest, ArrayList<Integer> path, List<List<Integer>> result){
        
        if(curr == dest){
            path.add(curr);
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        vis[curr] = true;
        path.add(curr);

        for(int v : graph[curr]){

            if(!vis[v])
                dfs(graph, vis, v, dest, path, result);
        }

        path.remove(path.size()-1);
        vis[curr] = false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        int N = graph.length;
        boolean[] vis = new boolean[N];

        dfs(graph, vis, 0, N-1, new ArrayList<>(), result);

        return result;
    }
}
