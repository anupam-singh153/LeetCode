class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length, l = 0, result = 0;

        for(int r = 0; r < n; ++r){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(l < r && map.get(nums[r]) > k){
                map.put(nums[l], map.get(nums[l])-1);
                l++;
            }

            result = Math.max(result, r-l+1);
        }
        
        return result;
    }
}
