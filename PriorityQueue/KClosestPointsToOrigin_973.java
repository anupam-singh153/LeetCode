class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] res = new int[k][2];

        Arrays.sort(points, (a, b) -> dist(a) - dist(b));

        for (int i = 0; i < k; ++i) {

            res[i] = points[i];
        }

        return res;
    }

    private int dist(int[] point) {

        return point[0] * point[0] + point[1] * point[1];

    }
}
