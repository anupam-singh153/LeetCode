class Solution {
    public int nthUglyNumber(int n) {

        int[] result = new int[n + 1];

        int ip2, ip3, ip5;
        ip2 = ip3 = ip5 = 1;

        result[1] = 1;

        for (int i = 2; i <= n; ++i) {

            int ip2Mul = result[ip2] * 2;
            int ip3Mul = result[ip3] * 3;
            int ip5Mul = result[ip5] * 5;

            int minimum = Math.min(ip2Mul, Math.min(ip3Mul, ip5Mul));

            if (minimum == ip2Mul)
                ip2++;
            if (minimum == ip3Mul)
                ip3++;
            if (minimum == ip5Mul)
                ip5++;

            result[i] = minimum;
        }

        return result[n];
    }
}
