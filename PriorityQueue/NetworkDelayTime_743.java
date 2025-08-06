import java.util.*;
import java.io.*;

class Solution {

    public int networkDelayTime(int[][] times, int N, int k) {
        
        List<int []>[] graph = new ArrayList[N+1];

        for(int i = 1; i <= N; ++i)
            graph[i] = new ArrayList<>();

        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int wt = t[2];

            graph[u].add(new int[]{wt,v});
        }

        int[] result = new int[N+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0];
            int u = curr[1];

            for(int[] nb : graph[u]){
                int dist = nb[0];
                int v = nb[1];

                if(dist + wt < result[v]){
                    result[v] = dist + wt;
                    pq.add(new int[]{dist + wt, v});
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= N; ++i)
            max = Math.max(max, result[i]);

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
