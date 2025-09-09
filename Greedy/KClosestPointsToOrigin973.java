class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (b, a) -> Integer.compare((a[0] * a[0] + a[1] * a[1]),
                        (b[0] * b[0] + b[1] * b[1])));

        for (int[] point : points) {

            maxHeap.add(point);

            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][];

        for (int i = 0; i < k; ++i)
            result[i] = maxHeap.poll();

        return result;
    }
}
