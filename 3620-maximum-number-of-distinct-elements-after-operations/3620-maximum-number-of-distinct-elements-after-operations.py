class Solution:
    def maxDistinctElements(self, nums, k):
        nums.sort()
        res, prev = 0, -10**9
        for x in nums:
            if max(x - k, prev + 1) <= x + k:
                prev = max(x - k, prev + 1)
                res += 1
        return res