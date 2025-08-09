class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n-2; ++i){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];

                if(sum == target)
                    return sum;

                if(Math.abs(sum - target) < Math.abs(closestSum - target))
                    closestSum = sum;

                if(sum < target)
                    l++;
                else
                    r--;
            }
        }

        return closestSum;
    }
}
