class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int r;
    private int c;
    private int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        r = grid.length;
        c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= r || col < 0 || col >= c) return 0;
        if (grid[row][col] == 0)  return 0;
        
        grid[row][col] = 0;
        int area = 1;
        for (int[] dir: DIRS) {
           area += dfs(grid, row + dir[0], col + dir[1]);
        }
        return area;
    }
}
