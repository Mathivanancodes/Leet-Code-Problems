class Solution {
    private double value(double n1, char op, double n2) {
        if (op == '+') return n1 + n2;
        if (op == '-') return n1 - n2;
        if (op == '*') return n1 * n2;
        if (op == '/') {
            if (Math.abs(n2) < 1e-6) return 1e9;
            return n1 / n2;
        }
        return 1e9;
    }

    private boolean isValid(double ans) {
        return Math.abs(ans - 24.0) < 1e-6;
    }

    private boolean evaluate(char op1, char op2, char op3, int[] cards) {
        double ans;

        // ((_ _)_)_
        ans = value(value(value(cards[0], op1, cards[1]), op2, cards[2]), op3, cards[3]);
        if (isValid(ans)) return true;

        // (_ _) (_ _)
        ans = value(value(cards[0], op1, cards[1]), op2, value(cards[2], op3, cards[3]));
        if (isValid(ans)) return true;

        // (_(_ _))_
        ans = value(value(cards[0], op1, value(cards[1], op2, cards[2])), op3, cards[3]);
        if (isValid(ans)) return true;

        // _(_(_ _))
        ans = value(cards[0], op1, value(value(cards[1], op2, cards[2]), op3, cards[3]));
        if (isValid(ans)) return true;

        // _(_(_ _))
        ans = value(cards[0], op1, value(cards[1], op2, value(cards[2], op3, cards[3])));
        if (isValid(ans)) return true;

        return false;
    }

    public boolean judgePoint24(int[] cards) {
        char[] ops = {'+', '-', '*', '/'};
        Arrays.sort(cards);

        do {
            for (char op1 : ops) {
                for (char op2 : ops) {
                    for (char op3 : ops) {
                        if (evaluate(op1, op2, op3, cards)) {
                            return true;
                        }
                    }
                }
            }
        } while (nextPermutation(cards));

        return false;
    }

    // Helper: next_permutation (like in C++)
    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
}