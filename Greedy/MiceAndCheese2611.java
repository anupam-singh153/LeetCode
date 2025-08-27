class Solution {

    private static class Pair implements Comparable<Pair> {
        int v1, v2;

        public Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public int compareTo(Pair that) {
            return that.v1 == that.v1 ? Integer.compare(that.v1 - that.v2, this.v1 - this.v2)
                    : Integer.compare(this.v1, that.v1);
        }
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < reward1.length; ++i) {
            pq.add(new Pair(reward1[i], reward2[i]));
        }
        int result = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (k > 0) {
                result += p.v1;
                k--;
            } else
                result += p.v2;
        }

        return result;
    }
}
