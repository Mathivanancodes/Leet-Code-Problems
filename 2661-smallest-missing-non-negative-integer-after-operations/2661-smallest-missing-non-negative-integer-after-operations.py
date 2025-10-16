class Solution(object):
    def findSmallestInteger(self, nums, value):
        rem = [0] * value
        for x in nums:
            rem[x % value] += 1
        res = 0
        while rem[res % value]:
            rem[res % value] -= 1
            res += 1
        return res