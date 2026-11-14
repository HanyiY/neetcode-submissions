class Solution {
    // DFS, from borders, search with dedup, see what islands can be reached
    // and return those can be reached by two oceans.
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // dedup + find which cell is reachable
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        // from borders
        for (int r = 0; r < m; r++) {
            dfs (heights, r, 0, pacificVisited);
            dfs (heights, r, n - 1, atlanticVisited);
        }

        for (int c = 0; c < n; c++) {
            dfs (heights, 0, c, pacificVisited);
            dfs (heights, m - 1, c, atlanticVisited);
        }
        // fill res
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]
                )   res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs (int[][] heights, int row, int col, boolean[][] visited) {        
        visited[row][col] = true;
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= heights.length || newRow < 0 || newCol >= heights[0].length || newCol < 0 || visited[newRow][newCol]) continue;
            if (heights[newRow][newCol] >= heights[row][col])
                dfs (heights, newRow, newCol, visited);
        }
    }
}
