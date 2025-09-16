class Solution {
    public int maxPoints(int[][] points) {

        int ans = 0, N = points.length;
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            int y1 = points[i][1];
            int x1 = points[i][0];

            map.clear();

            for (int j = i + 1; j < N; ++j) {

                int y2 = points[j][1];
                int x2 = points[j][0];

                double m;

                if (x1 == x2)
                    m = 1e8;
                else if (y1 == y2)
                    m = 0;
                else
                    m = 1.0 * (y1 - y2) / (x1 - x2);

                map.put(m, map.getOrDefault(m, 0) + 1);
            }
            for (int val : map.values()) {
                ans = Math.max(ans, val);
            }
        }
        return 1 + ans;
    }
}
