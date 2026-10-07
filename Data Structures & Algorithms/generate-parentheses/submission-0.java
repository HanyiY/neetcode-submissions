class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs (0, 0, n, sb, res);
        return res;
    }

    private void dfs(int leftAdded, int rightAdded, int n, StringBuilder sb, List<String> res) {
        if (leftAdded == n && rightAdded == n) {
            res.add(sb.toString());
        }

        if (leftAdded < n) {
            sb.append("(");
            dfs(leftAdded + 1, rightAdded, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightAdded < leftAdded) {
            sb.append(")");
            dfs(leftAdded, rightAdded + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
