class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        
         int n = nums.length;
         int [] prefixSum = new int [n+1];
        
         for(int [] query : queries){
             
              int l = query[0];
              int r = query[1];
             
              prefixSum[l] += 1;
              prefixSum[r+1] -= 1;
         }
        
         for(int i = 1; i <= n; ++i){
             prefixSum[i] += prefixSum[i-1];
         }
        
         for(int i = 0; i < n; ++i){
             
              if(prefixSum[i] < nums[i])
                    return false;
         }
        
         return true;
    }
}
