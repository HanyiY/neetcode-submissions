class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] represents maxsum subarray end at i, inclusively
        // On, On
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}

// test: [2, -3, 4] should return 4
// dp:  [2, -1, 4]
// max:  2 4
