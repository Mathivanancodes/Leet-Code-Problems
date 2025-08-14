class Solution {
    public String largestGoodInteger(String num) {
        // Assign 'maxDigit' to the NUL character (smallest ASCII value character)
        char maxDigit = '\0';

        // Iterate on characters of the num string.
        for (int index = 0; index <= num.length() - 3; ++index) {
            // If 3 consecutive characters are the same, 
            // store the character in 'maxDigit' if it's bigger than what it already stores.
            if (num.charAt(index) == num.charAt(index + 1) && num.charAt(index) == num.charAt(index + 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(index));
            }
        }

        // If 'maxDigit' is NUL, return an empty string; otherwise, return a string of size 3 with 'maxDigit' characters.
        return maxDigit == '\0' ? "" : new String(new char[]{maxDigit, maxDigit, maxDigit});
    }
}