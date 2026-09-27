class Solution {
    // TC: O(r * c)
    // SC: O(r * c)
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int r;
    int c;
    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int count = 0;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, char[][] grid){
        // boundary check
        if (row < 0 || row >= r || col < 0 || col >= c){
            return;
        }

        if (grid[row][col] == '0'){
            return;
        }

        // mark it as visited
        grid[row][col] = '0';

        // recursively explore all four directions
        for (int[] dir: DIRS){
            dfs(row + dir[0], col + dir[1], grid);
        }

    }
}
