class Solution {
    static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (dfs(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index){
        if (index == word.length()){
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index) || visited[r][c]){
            return false;
        }

        visited[r][c] = true;
        for (int[] dir : DIRS){
            if(dfs(board, word, r + dir[0], c + dir[1], index + 1)){
                return true;
            }
        }
        visited[r][c] = false;

        return false;
    }
}
