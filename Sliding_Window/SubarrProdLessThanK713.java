class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int l = 0, result = 0;
        long product = 1;

        for(int r = 0; r < nums.length; ++r){

            product *= nums[r];

            while(l <= r && product >= k){

                product /= nums[l];
                l++;
            }

            result += r-l+1;
        }

        return result;
    }
}
