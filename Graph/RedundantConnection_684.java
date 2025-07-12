import java.util.*;
import java.io.*;

class RedundantConnection_684 {

    private int[] parent, rank;

    private void union(int u, int v){

        int pU = find(u);
        int pV = find(v);

        if(pU == pV)
            return;

        if(rank[pU] > rank[pV])
            parent[pV] = pU;

        else if(rank[pU] < rank[pV])
            parent[pU] = pV;

        else{
            rank[pU] += 1;
            parent[pV] = pU;
        }
    }

    private int find(int x){

        if(x == parent[x])
            return x;

        return x = find(parent[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        
        int N = edges.length;
        parent = new int[N+1];
        rank = new int[N+1];

        for(int i = 1; i <= N; ++i)
            parent[i] = i;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(find(u) == find(v))
                return e;
            else
                union(u,v);
        }

        return new int[]{-1,-1};
    }
}
