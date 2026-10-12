class Solution {
    // mutil source BFS
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int timeStamp = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        // boolean everMeetFresh = false;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean meetFresh = false;
            for (int i = 0; i < size; i++) {
                
                int[] cur = q.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                for (int[] direction: directions) {
                    int newRow = curRow + direction[0];
                    int newCol = curCol + direction[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        meetFresh = true;
                        // everMeetFresh = true;
                        q.offer(new int[] {newRow, newCol});
                    }
                }
            }
            if (meetFresh)   timeStamp++; // 对于boolean flag 永远写 if (flag) 就会避免== true 写错成= true
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return timeStamp;
    }
}
