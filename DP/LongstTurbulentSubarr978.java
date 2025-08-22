class Solution {

    private int solve(int[] arr, int i, int sign, int N, int[][] dp){

        if(i == N-1)
            return 1;

        if(dp[i][sign == 1 ? 1 : 0] != -1)
            return dp[i][sign == 1 ? 1 : 0];
        
        int symbol = Integer.compare(arr[i+1], arr[i]);

        int result = 1;
        
        if(sign * symbol > 0)
            result = 1 + solve(arr, i+1, sign*-1, N, dp);
        
        return dp[i][sign == 1 ? 1 : 0] = result;
    }
    
    public int maxTurbulenceSize(int[] arr) {

        int N = arr.length;
        int result = 0;

        int[][] dp = new int[N][2];

        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        for(int i = 0; i < N; ++i){
            int negSign = solve(arr, i, 1, N, dp);
            int posSign = solve(arr, i, -1, N, dp);

            result = Math.max(result, Math.max(negSign, posSign));
        }

        return result;
    }
}
