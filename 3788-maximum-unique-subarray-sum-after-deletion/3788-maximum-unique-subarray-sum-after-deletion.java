class Solution {
    public int maxSum(int[] nums) {
        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= 0) {
                allNegative = false;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        if (allNegative)
            return maxValue;

        boolean[] seen = new boolean[101];
        for (int n : nums) {
            if (n >= 0 && n < 101) {
                seen[n] = true;
            }
        }

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (seen[i]) {
                sum += i;
            }
        }

        return sum;
    }
}