class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSizes = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);

        int partitionStart = 0, partitionEnd = 0;

        // Store the last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            // Store the first occurrence index of each character (if not set)
            if (firstOccurrence[s.charAt(i) - 'a'] == -1) {
                firstOccurrence[s.charAt(i) - 'a'] = i;
            }

            // If we find a new partition start
            if (partitionEnd < firstOccurrence[s.charAt(i) - 'a']) {
                partitionSizes.add(partitionEnd - partitionStart + 1);
                partitionStart = i;
                partitionEnd = i;
            }

            // Update partition end boundary
            partitionEnd = Math.max(
                partitionEnd,
                lastOccurrence[s.charAt(i) - 'a']
            );
        }

        // Add the last partition if it exists
        if (partitionEnd - partitionStart + 1 > 0) {
            partitionSizes.add(partitionEnd - partitionStart + 1);
        }

        return partitionSizes;
    }
}