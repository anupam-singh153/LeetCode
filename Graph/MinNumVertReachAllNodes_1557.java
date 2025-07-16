import java.util.*;
import java.io.*;

class MinNumVertReachAllNodes_1557 {
    public List<Integer> findSmallestSetOfVertices(int N, List<List<Integer>> edges) {
        
        List<Integer> result = new ArrayList<>();

        int[] inDegree = new int[N];

        for(List<Integer> e : edges){
            int u = e.get(0);
            int v = e.get(1);

            inDegree[v] += 1;
        }

        boolean[] vis = new boolean[N];
        
        for(int i = 0; i < N; ++i){
            
            if(inDegree[i] == 0)
                result.add(i);
        }

        return result;
    }
}