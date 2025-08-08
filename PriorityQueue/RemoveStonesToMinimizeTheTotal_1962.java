class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int pile : piles) {
            pq.add(pile);
        }

        int oper = 0;

        while (oper++ < k) {

            int pile = pq.poll();

            pile -= pile / 2;
            pq.add(pile);
        }

        int ans = 0;

        while (!pq.isEmpty())
            ans += pq.poll();

        return ans;
    }
}
