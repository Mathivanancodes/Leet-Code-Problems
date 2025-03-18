class Solution {

    public int longestNiceSubarray(int[] nums) {
        // Binary search for the longest nice subarray length
        int left = 0, right = nums.length;
        int result = 1; // Minimum answer is 1 (as subarrays of length 1 are always nice)

        while (left <= right) {
            int length = left + (right - left) / 2;
            if (canFormNiceSubarray(length, nums)) {
                result = length; // Update the result
                left = length + 1; // Try to find a longer subarray
            } else {
                right = length - 1; // Try a shorter length
            }
        }
        return result;
    }

    private boolean canFormNiceSubarray(int length, int[] nums) {
        if (length <= 1) return true; // Subarray of length 1 is always nice

        // Try each possible starting position for subarray of given length
        for (int start = 0; start <= nums.length - length; ++start) {
            int bitMask = 0; // Tracks the bits used in the current subarray
            boolean isNice = true;

            // Check if the subarray starting at 'start' with 'length' elements is nice
            for (int pos = start; pos < start + length; ++pos) {
                // If current number shares any bits with existing mask,
                // the subarray is not nice
                if ((bitMask & nums[pos]) != 0) {
                    isNice = false;
                    break;
                }
                bitMask |= nums[pos]; // Add current number's bits to the mask
            }

            if (isNice) return true; // Found a nice subarray of the specified length
        }
        return false; // No nice subarray of the given length exists
    }
}