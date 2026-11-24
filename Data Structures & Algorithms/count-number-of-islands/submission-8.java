class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int r;
    private int c;
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        r = grid.length;
        c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(i, j, grid);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0'; // visited
        for (int[] dir : DIRS) {
            int newR = i + dir[0];
            int newC = j + dir[1];
            if (newR >= 0 && newR < r && newC >= 0 && newC < c && grid[newR][newC] == '1') {
                dfs(newR, newC, grid);
            }
        }     
    }
}
