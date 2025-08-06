class Solution {

    private static class Fraction implements Comparable<Fraction> {

        int n, d;

        public Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Fraction that) {
            return Double.compare(1.0 * this.n / this.d, 1.0 * that.n / that.d);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<Fraction> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {

                pq.add(new Fraction(arr[i], arr[j]));
            }
        }

        for (int i = 1; i < k; ++i)
            pq.poll();

        Fraction f = pq.poll();

        return new int[] { f.n, f.d };
    }
}
