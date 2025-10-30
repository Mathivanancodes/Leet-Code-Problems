class Solution:
    def minNumberOperations(self, t: List[int]) -> int:
        return t[0]+sum(max(x-y, 0) for x, y in zip(t[1:], t))