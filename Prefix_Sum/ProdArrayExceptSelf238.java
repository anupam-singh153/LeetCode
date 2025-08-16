class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];

        int product = 1;

        for(int i = 0; i < n; ++i){
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for(int j = n-1; j >= 0; --j){
            result[j] *= product;
            product *= nums[j];
        }

        return result;
    }
}
