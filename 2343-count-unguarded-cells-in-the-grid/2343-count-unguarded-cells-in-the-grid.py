class Solution:
    def dfs(self, r, c, dir, vis, mp):
        n, m = len(vis), len(vis[0])
        if r < 0 or c < 0 or r >= n or c >= m:
            return
        if (r, c) in mp:
            return
        vis[r][c] = 1

        if dir == "r":
            self.dfs(r, c + 1, "r", vis, mp)
        if dir == "l":
            self.dfs(r, c - 1, "l", vis, mp)
        if dir == "u":
            self.dfs(r - 1, c, "u", vis, mp)
        if dir == "d":
            self.dfs(r + 1, c, "d", vis, mp)

    def countUnguarded(self, m, n, guards, walls):
        vis = [[0] * n for _ in range(m)]
        mp = {}

        for r, c in guards:
            mp[(r, c)] = 1
            vis[r][c] = 1

        for r, c in walls:
            mp[(r, c)] = 1
            vis[r][c] = 1

        for r, c in guards:
            self.dfs(r, c + 1, "r", vis, mp)
            self.dfs(r, c - 1, "l", vis, mp)
            self.dfs(r + 1, c, "d", vis, mp)
            self.dfs(r - 1, c, "u", vis, mp)

        cnt = 0
        for i in range(m):
            for j in range(n):
                if vis[i][j] == 0:
                    cnt += 1
        return cnt