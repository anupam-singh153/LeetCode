import java.util.*;
import java.io.*;

class IsGraphBipartite_785 {

    private boolean dfs(int[][] graph, int[] color, int u, int currColor){

        color[u] = currColor;

        for(int v : graph[u]){

            int newColor = 3-currColor;

            if(color[v] == currColor)
                return false;

            if(color[v] == 0 && !dfs(graph, color, v, newColor))
                return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        
        int V = graph.length;
        int[] color = new int[V];

        for(int u = 0; u < V; ++u){

            if(color[u] == 0 && !dfs(graph,color,u,1))
                return false;
        }

        return true;
    }
}
