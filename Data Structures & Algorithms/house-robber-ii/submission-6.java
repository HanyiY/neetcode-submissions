class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // int[] lastExcluded = new int[n - 1];
        // int[] firstExcluded = new int[n - 1];
        // for (int i = 0; i < n - 1; i++){
        //     lastExcluded[i] = nums[i];
        // }
        // for (int i = 1; i < n; i++){
        //     firstExcluded[i - 1] = nums[i];
        // }
        return Math.max(noLimitRob(Arrays.copyOfRange(nums, 1, nums.length)), 
                        noLimitRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int noLimitRob(int[] nums){
        if (nums.length == 0)   return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n + 1; i++){
            int robI = dp[i - 2] + nums[i - 1];
            int notRobI = dp[i - 1];
            dp[i] = Math.max(robI, notRobI);
        }
        return dp[n];
    }
}
