import heapq

class Solution:
    def swimInWater(self, grid: list[list[int]]) -> int:
        n = len(grid)
        visited = [[False]*n for _ in range(n)]
        min_heap = [(grid[0][0], 0, 0)]
        max_time = 0

        while min_heap:
            current_height, row, col = heapq.heappop(min_heap)
            if visited[row][col]:
                continue
            visited[row][col] = True
            max_time = max(max_time, current_height)
            if row == n-1 and col == n-1:
                return max_time
            for dr, dc in ((1,0),(-1,0),(0,1),(0,-1)):
                new_row, new_col = row + dr, col + dc
                if 0 <= new_row < n and 0 <= new_col < n and not visited[new_row][new_col]:
                    heapq.heappush(min_heap, (grid[new_row][new_col], new_row, new_col))
        return max_time