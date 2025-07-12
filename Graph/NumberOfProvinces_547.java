import java.util.*;
import java.io.*;

class NumberOfProvinces_547 {

    private void dfs(int[][] isConnected, int u, boolean[] vis){

        vis[u] = true;

        for(int v = 0; v < isConnected.length; ++v){

            if(isConnected[u][v] == 1 && !vis[v])
                dfs(isConnected, v, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        int N = isConnected.length;
        boolean[] vis = new boolean[N];
        int provinces = 0;

        for(int i = 0; i < N; ++i){

            if(!vis[i]){
                dfs(isConnected, i, vis);
                provinces += 1;
            }
        }

        return provinces;
    }
}
