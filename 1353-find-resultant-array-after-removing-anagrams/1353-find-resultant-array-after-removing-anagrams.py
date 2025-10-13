class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        ana = [''.join(sorted(w)) for w in words]
        ans = [words[0]]

        for i in range(1, len(words)):
            if ana[i] != ana[i - 1]:
                ans.append(words[i])

        return ans