class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        
        int top = 0;
        int left = 0;
        int bot = m - 1;
        int right = n - 1;

        ListNode cur = head;
        while (top <= bot && left <= right && cur != null) {
            for (int i = left; i <= right; i++) {
                if (cur == null) break;
                res[top][i] = cur.val;
                cur = cur.next;
            }top++;
            if (cur != null) {
                for (int i = top; i <= bot; i++) {
                    if (cur == null) break;
                    res[i][right] = cur.val;
                    cur = cur.next;
                }right--;
            }
            if (top <= bot && cur != null) {
                for (int i = right; i >= left; i--) {
                    if (cur == null) break;
                    res[bot][i] = cur.val;
                    cur = cur.next;
                }bot--;
            }
            if (left <= right && cur != null) {
                for (int i = bot; i >= top; i--) {
                    if (cur == null) break;
                    res[i][left] = cur.val;
                    cur = cur.next;
                } left++;
            }
        }
        
        return res;
    }
}
