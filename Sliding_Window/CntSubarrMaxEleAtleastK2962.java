class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = nums[0];
        for (int num : nums)
            maxEle = Math.max(maxEle, num);

        int l = 0, cnt = 0;
        long result = 0;

        for (int r = 0; r < nums.length; ++r) {
            if (nums[r] == maxEle)
                cnt++;

            while (cnt >= k) { 
                result += nums.length - r;
                
                if (nums[l] == maxEle)
                    cnt--;
                l++;
            }
        }

        return result;
    }
}
