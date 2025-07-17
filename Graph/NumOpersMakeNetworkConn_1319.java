import java.util.*;
import java.io.*;

class NumOpersMakeNetworkConn_1319 {

    private int[] rank, parent;

    private void union(int u, int v){

        int pU = find(u);
        int pV = find(v);

        if(pU == pV)
            return;

        if(rank[pU] < rank[pV])
            parent[pU] = pV;

        else if(rank[pU] > rank[pV])
            parent[pV] = pU;

        else{
            parent[pV] = pU;
            rank[pU]++;
        }
    }

    private int find(int u){

        if(u == parent[u])
            return u;

        return parent[u] = find(parent[u]);
    }

    public int makeConnected(int N, int[][] connections) {
        
        int components = N;
        int M = connections.length;

        if(M < N-1)
            return -1;

        this.parent = new int[N];
        this.rank = new int[N];

        for(int i = 0; i < N; ++i)
            parent[i] = i;

        for(int[] con : connections){
            int u = find(con[0]);
            int v = find(con[1]);

            if(u != v){
                union(u,v);
                components -= 1;
            }
        }

        return components-1;
    }
}
