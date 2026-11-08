class Solution {
    public int jump(int[] nums) {
        //dp[i] means min jump from i to end
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] >= n - 1 - i)    dp[i] = 1; // 1 step to end
            else {
                int curMin = Integer.MAX_VALUE;
                for (int j = i + 1; j <= n - 2; j++) {
                    if (j - i <= nums[i] && dp[j] != Integer.MAX_VALUE) {
                        curMin = Math.min(curMin, dp[j] + 1);
                    }
                }
                dp[i] = curMin;
            }
            
        }
        return dp[0];
    }
}
