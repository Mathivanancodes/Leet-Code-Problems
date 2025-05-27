class Solution {
    private static final int INF = Integer.MAX_VALUE;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);
            
        int[][] count = new int[n][26];
        int[] vis = new int[n];
        int ans = 0;

        for (int i = 0; i < n && ans != INF; i++) {
            ans = Math.max(ans, dfs(i, colors, adj, count, vis));
        }
        return ans == INF ? -1 : ans;
    }

    private int dfs(int node, String colors,List<List<Integer>> adj,int[][] count,int[] vis) {
        if (vis[node] == 1)
            return INF;
        if (vis[node] == 2) {
            return count[node][colors.charAt(node) - 'a'];
        }

        vis[node] = 1;
        for (int nxt : adj.get(node)) {
            int res = dfs(nxt, colors, adj, count, vis);
            if (res == INF)
                return INF;
            for (int c = 0; c < 26; c++) {
                count[node][c] = Math.max(count[node][c], count[nxt][c]);
            }
        }
        int col = colors.charAt(node) - 'a';
        count[node][col]++;
        vis[node] = 2;

        return count[node][col];
    }
}