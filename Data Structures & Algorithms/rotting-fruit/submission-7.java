class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)    q.offer(new int[] {i, j});
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean meetFresh = false;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curRow = cur[0], curCol = cur[1];
                for (int[] dir : DIRS) {
                    int newRow = curRow + dir[0];
                    int newCol = curCol + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        meetFresh = true;
                        grid[newRow][newCol] = 2;
                        q.offer(new int[] {newRow, newCol});
                    }
                }
            }
            if (meetFresh) time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)    return -1;
            }
        }

        return time;
    }
}
