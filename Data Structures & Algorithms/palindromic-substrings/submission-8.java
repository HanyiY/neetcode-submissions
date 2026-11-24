class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), res = 0;
        boolean[][] dp = new boolean[len][len];

        // expand to dp[i][j] depends on dp[i+1][j-1].
        // i 倒序遍历， j正序遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
