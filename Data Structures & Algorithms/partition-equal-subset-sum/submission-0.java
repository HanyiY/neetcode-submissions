class Solution {
    // 倒序保证每个 num 最多使用一次。
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   

        for (int num: nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[target]) return true;
        }
        return dp[target];
    }
}

// nums = [1,2,3,4] target = 5;
// 
