class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        n = len(nums)
        count = 0
        left = [0] * n
        right = [0] * n

        for i in range(1, n):
            left[i] = left[i - 1] + nums[i - 1]
            right[n - i - 1] = right[n - i] + nums[n - i]

        for i in range(n):
            if nums[i] != 0:
                continue
            if left[i] == right[i]:
                count += 2
            elif abs(left[i] - right[i]) == 1:
                count += 1

        return count
