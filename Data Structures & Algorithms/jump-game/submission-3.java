class Solution {
    public boolean canJump(int[] nums) {
        // dp[i] = true means start from i, I can reach last index.
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //我能跳到true的中转站 (包括末尾)
                if (dp[j] &&  j - i <= nums[i]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
