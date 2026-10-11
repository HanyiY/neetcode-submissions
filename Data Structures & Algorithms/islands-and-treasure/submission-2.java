class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        //multi-source init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir: directions) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
                
        }
    }
}
