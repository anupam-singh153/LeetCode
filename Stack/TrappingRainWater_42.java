class Solution {
    public int trap(int[] height) {
        
         int n = height.length;
         int[] leftBoundary = new int[n];
         int[] rightBoundary = new int[n];

         leftBoundary[0] = height[0];
         for(int i = 1; i < n; ++i)
             leftBoundary[i] = Math.max(leftBoundary[i-1],height[i]);

         rightBoundary[n-1] = height[n-1];
         for(int i = n-2; i >= 0; --i)
             rightBoundary[i] = Math.max(rightBoundary[i+1],height[i]);

         int trappedWater = 0;
         for(int i = 0; i < n; ++i){
            trappedWater += Math.min(leftBoundary[i],rightBoundary[i])-height[i];
         }

         return trappedWater;
    }
}
