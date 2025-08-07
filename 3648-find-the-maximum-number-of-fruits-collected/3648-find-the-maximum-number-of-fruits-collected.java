class Solution {
    public int maxCollectedFruits(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += grid[i][i];
        }
        for (int pass = 0; pass < 2; pass++) {
            if (pass == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int tmp = grid[i][j];
                        grid[i][j] = grid[j][i];
                        grid[j][i] = tmp;
                    }
                }
            }
            int[] prev = new int[n], curr = new int[n];
            Arrays.fill(prev, -1);
            prev[n - 1] = grid[0][n - 1];
            for (int row = 1; row < n - 1; row++) {
                Arrays.fill(curr, -1);
                for (int i = 0; i < n; i++) {
                    if (prev[i] < 0) continue;
                    if (i > 0)  curr[i - 1] = Math.max(curr[i - 1], prev[i] + grid[row][i - 1]);
                    if (i < n - 1) curr[i + 1] = Math.max(curr[i + 1], prev[i] + grid[row][i + 1]);
                    curr[i] = Math.max(curr[i], prev[i] + grid[row][i]);
                }
                int[] tmp = prev; prev = curr; curr = tmp;
            }
            res += prev[n - 1];
        }
        return res;
    }
}