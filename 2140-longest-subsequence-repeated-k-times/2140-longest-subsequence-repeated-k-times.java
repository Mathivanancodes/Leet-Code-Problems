class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        List<Character> candidate = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidate.add((char) ('a' + i));
            }
        }

        Queue<String> q = new LinkedList<>();
        for (char ch : candidate) {
            q.add(String.valueOf(ch));
        }
        String ans = "";
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > ans.length()) {
                ans = curr;
            }
            // generate the next candidate string
            for (char ch : candidate) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) {
                    q.add(next);
                }
            }
        }

        return ans;
    }

    private boolean isKRepeatedSubsequence(String s, String t, int k) {
        int pos = 0, matched = 0;
        int m = t.length();
        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(pos)) {
                pos++;
                if (pos == m) {
                    pos = 0;
                    matched++;
                    if (matched == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}