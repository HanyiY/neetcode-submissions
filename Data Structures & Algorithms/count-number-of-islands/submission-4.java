class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int r;
    private int c;
    public int numIslands(char[][] grid) {
        int count = 0;
        r = grid.length;
        c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= r || col < 0 || col >= c) return;
        if (grid[row][col] == '0')  return;
        grid[row][col] = '0';
        for (int[] dir: DIRS) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}
