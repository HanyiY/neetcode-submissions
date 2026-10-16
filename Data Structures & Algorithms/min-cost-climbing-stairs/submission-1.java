class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // def dp[i]: the min cost to just reach i.
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return Math.min(dp[n-1] + cost[n-1], dp[n-2] + cost[n-2]);
    }
}
