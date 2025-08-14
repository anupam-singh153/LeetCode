class Solution {
    public int solve(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, l = 0;
        int result = 0;

        for(int r = 0; r < n; ++r){

            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.size() > k){

                map.put(nums[l], map.getOrDefault(nums[l], 0)-1);

                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                l++;
            }
            
            result += r-l+1;
        }
        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return solve(nums, k) - solve(nums, k-1);
    }
}
