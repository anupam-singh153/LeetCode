import java.util.*;
import java.io.*;

class NthTribonacciNumber_1137 {

    private int[] dp;

    public int tribonacci(int n){

        dp = new int[n+1];
        return tribo(n);
    }

    private int tribo(int n) {
        
        if(n < 3)
            return n == 0 ? 0 : 1;

        if(dp[n] != 0)
            return dp[n];

        return dp[n] = tribo(n-1) + tribo(n-2) + tribo(n-3);
    }
}
