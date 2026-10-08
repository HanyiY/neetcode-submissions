class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> cur = new ArrayList<>();
    private List<Integer> curPos = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) sb.append('.');
        dfs(0, n);
        return res;
    }

    private void dfs (int level, int n) {
        if (level == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                sb.setCharAt(i, 'Q');
                cur.add(sb.toString());
                sb.setCharAt(i, '.');
                curPos.add(i);
                dfs(level + 1, n);
                curPos.remove(curPos.size() - 1);
                cur.remove(cur.size() - 1);
                
            }
        }
    }

    private boolean isValid(List<String> cur, int col) {
        int row = cur.size(); 
        for (int r = 0; r < cur.size(); r++) {
            if (curPos.get(r) == col) return false;
            if (Math.abs(row - r) == Math.abs(col - curPos.get(r))) return false;
        }
        return true;
    }
}
