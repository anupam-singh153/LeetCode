class Solution {
    public long continuousSubarrays(int[] nums) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->Integer.compare(b,a));
        int n = nums.length;
        int l = 0;
        long result = 0;

        for(int r = 0; r < n; ++r){

            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.firstEntry().getKey() - map.lastEntry().getKey() > 2){

                map.put(nums[l], map.get(nums[l])-1);

                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                l++;
            }

            result += r-l+1;
        }

        return result;
    }
}
