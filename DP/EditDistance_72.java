class Solution {

    //Recursive Approach
    int[][] dp;

    public int solve(String s1,String s2,int i,int j){

         if(i < 0) return j+1;
         if(j < 0) return i+1;

         if(dp[i][j] != -1) return dp[i][j];

         if(s1.charAt(i) == s2.charAt(j))
                return solve(s1,s2,i-1,j-1);

         //Otherwise perform operations
         int insOp = solve(s1,s2,i,j-1);

         int delOp = solve(s1,s2,i-1,j);

         int repOp = solve(s1,s2,i-1,j-1);

         return dp[i][j] = 1 + Math.min(repOp,Math.min(insOp,delOp));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        dp = new int[m][n];

        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return solve(word1,word2,m-1,n-1);
    }
}
