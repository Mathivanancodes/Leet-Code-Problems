class Solution {

    private static final long MOD = 1_000_000_007;
    private long[][][] memo;
    private int[] cnt;
    private int[] psum;
    private int target;
    private long[][] comb;

    public int countBalancedPermutations(String num) {
        int tot = 0, n = num.length();
        cnt = new int[10];
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            cnt[d]++;
            tot += d;
        }
        if (tot % 2 != 0) {
            return 0;
        }

        target = tot / 2;
        int maxOdd = (n + 1) / 2;

        /* Pre-calculate combinations */
        comb = new long[maxOdd + 1][maxOdd + 1];
        for (int i = 0; i <= maxOdd; i++) {
            comb[i][i] = comb[i][0] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        psum = new int[11];
        for (int i = 9; i >= 0; i--) {
            psum[i] = psum[i + 1] + cnt[i];
        }

        memo = new long[10][target + 1][maxOdd + 1];
        for (long[][] arr2 : memo) {
            for (long[] arr1 : arr2) {
                Arrays.fill(arr1, -1);
            }
        }

        return (int) dfs(0, 0, maxOdd);
    }

    private long dfs(int pos, int curr, int oddCnt) {
        /* If the remaining positions cannot be legally filled, or if the sum of the elements at the current odd positions is greater than the target value */
        if (oddCnt < 0 || psum[pos] < oddCnt || curr > target) {
            return 0;
        }
        if (pos > 9) {
            return curr == target && oddCnt == 0 ? 1 : 0;
        }
        if (memo[pos][curr][oddCnt] != -1) {
            return memo[pos][curr][oddCnt];
        }
        /* Even-numbered positions remaining to be filled */
        int evenCnt = psum[pos] - oddCnt;
        long res = 0;
        for (
            int i = Math.max(0, cnt[pos] - evenCnt);
            i <= Math.min(cnt[pos], oddCnt);
            i++
        ) {
            /* The current digit is filled with i positions at odd positions, and cnt[pos] - i positions at even positions */
            long ways = (comb[oddCnt][i] * comb[evenCnt][cnt[pos] - i]) % MOD;
            res =
                (res +
                    ((ways * dfs(pos + 1, curr + i * pos, oddCnt - i)) % MOD)) %
                MOD;
        }
        memo[pos][curr][oddCnt] = res;
        return res;
    }
}