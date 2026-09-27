class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];

        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if (board[row][col] == '.') continue;
                int boxNumber = (row / 3) * 3 + (col / 3);
                if (rowCheck[board[row][col] - '1'][row] || colCheck[board[row][col] - '1'][col] || boxCheck[board[row][col] - '1'][boxNumber]){
                    return false;
                }
                rowCheck[board[row][col] - '1'][row] = true;
                colCheck[board[row][col] - '1'][col] = true;
                
                boxCheck[board[row][col] - '1'][boxNumber] = true;
            }
        }

        return true;
    }
}

// boolean[which digit][row/col/box]: true -> appear