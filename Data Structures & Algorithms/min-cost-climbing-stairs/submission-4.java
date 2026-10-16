class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // def dp[i]: the min cost to just reach i.
        int n = cost.length;
        int prev2 = 0, prev1 = 0;
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            res = Math.min(prev2 + cost[i-2], prev1 + cost[i-1]);
            prev2 = prev1;
            prev1 = res;
        }
        return res;
        //return Math.min(dp[n-1] + cost[n-1], dp[n-2] + cost[n-2]);
    }
}
