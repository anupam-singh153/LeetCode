class Solution {
    public int furthestBuilding(int[] h, int bricks, int ladders) {

        int n = h.length;

        PriorityQueue<Integer> ladderGaps = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            int gap = h[i + 1] - h[i];
            if (gap > 0)
                ladderGaps.offer(gap);

            if (ladderGaps.size() > ladders)
                bricks -= ladderGaps.poll();

            if (bricks < 0)
                return i;
        }

        return n - 1;
    }
}
