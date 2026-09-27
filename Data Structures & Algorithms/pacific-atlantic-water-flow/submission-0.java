class Solution {
    int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: 第一列 + 第一行
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
        }

        // Atlantic: 最后一列 + 最后一行
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j);
        }

        // collect result
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

     private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        int m = heights.length;
        int n = heights[0].length;

        visited[r][c] = true;
       
        // ❗1. 向四个方向扩展
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];

             // ❗2. 越界判断（return）
            if (nr < 0 || nr >= m || nc < 0 || nc >= n)  continue;
            // ❗3. visited 判断（return）
            if (visited[nr][nc])  continue;
            // ❗4. 标记 visited
            

            // ❗5. 写“反向流”条件（continue）
            if (heights[nr][nc] < heights[r][c])    continue;

            dfs(heights, visited, nr, nc);
        }
    }

}
