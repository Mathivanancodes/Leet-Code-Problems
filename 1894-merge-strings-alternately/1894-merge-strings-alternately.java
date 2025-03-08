public class Solution {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        // Alternate merging characters from both strings
        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // Append remaining characters
        result.append(word1.substring(i));
        result.append(word2.substring(j));

        return result.toString();
    }
}