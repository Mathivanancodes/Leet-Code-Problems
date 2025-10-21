class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        M=max(nums)+2
        freq, sweep=[0]*M, [0]*M
        mm=M
        for x in nums:
            freq[x]+=1
            s, t=max(1, x-k), min(M-1, x+k+1)
            sweep[s]+=1
            sweep[t]-=1
            mm=min(mm, s)
        ans, cnt=0, 0
        for x in range(mm, M):
            cnt+=sweep[x]
            ans=max(ans, freq[x]+min(numOperations, cnt-freq[x]))
        return ans