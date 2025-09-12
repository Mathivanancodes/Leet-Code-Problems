class Solution {
    private long stepsum(long n) {
        if (n <= 0) return 0;
        long res = 0, base = 1, step = 1;
        while (base <= n) {
            long cnt = Math.min(n, base * 4 - 1) - base + 1;
            res += cnt * step;
            base *= 4;
            step++;
        }
        return res;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long total = stepsum(r) - stepsum(l - 1);
            ans += (total + 1) / 2;
        }
        return ans;
    }
}