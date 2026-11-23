class Solution {
    public int change(int amount, int[] coins) {
        // dp[i]: given processed coin types, how many combos to make i dollars.
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
