class Solution {
    int[] toFreqArray(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }

    boolean isEqualFrequency(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    boolean reorderedPowerOf2(int n) {
        int[] target = toFreqArray(n);

        for (int i = 0; i < 31; i++) {
            int powerOf2 = 1 << i;
            if (isEqualFrequency(target, toFreqArray(powerOf2))) {
                return true;
            }
        }
        return false;
    }

}