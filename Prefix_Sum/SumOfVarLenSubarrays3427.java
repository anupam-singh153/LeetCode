class Solution {
    public int subarraySum(int[] nums) {
        
        int n = nums.length;
        int [] prefixSum = new int [n];
        
        int ans = 0;
        prefixSum[0] = nums[0];
        
        for(int i = 1; i < n; ++i){
             prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        for(int i = 0; i < n; ++i){
            
             int st = Math.max(0,i-nums[i]);
             ans += prefixSum[i];
            
             if(st > 0)
             ans -= prefixSum[st-1];
        }
        
        return ans;
    }
}
