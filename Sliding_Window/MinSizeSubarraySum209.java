class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int l = 0;
        int n = nums.length;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int r = 0; r < n; ++r){

            sum += nums[r];

            while(l <= r && sum >= target){
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }
        }

         while(l <= n && sum >= target){
                minLen = Math.min(minLen, n-l+1);
                sum -= nums[l++];
            }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
