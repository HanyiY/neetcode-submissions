class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        //反着来，从边上的o出发找能存活下来的O，临时标记成#来避免重复访问
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        // for (int i = 0; i < m; i += (m - 1)) {
        //     for (int j = 0; j < n; j++) {
        //         if (board[i][j] == 'O') {
        //             q.offer(new int[] {i, j});
        //         }
        //     }
        // }
        //           被 edge case 出错了
        // for (int i = 1; i < m - 1; i++) {
        //     for (int j = 0; j < n; j += (n - 1)) {
        //         if (board[i][j] == 'O') {
        //             q.offer(new int[] {i, j});
        //         }
        //     }
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean onBorder = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (onBorder && board[i][j] == 'O') {
                    board[i][j] = '#';
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
                int[] cur = q.poll();
                board[cur[0]][cur[1]] = '#';
                for (int[] dir: directions) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    //找内部
                    if (newRow > 0 && newRow < m - 1 && newCol > 0 && newCol < n - 1 
                    && board[newRow][newCol] == 'O') {
                        q.offer(new int[] {newRow, newCol});
                    }
                }           
        }
        // 后处理
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
                
            }
        }

    }
}
