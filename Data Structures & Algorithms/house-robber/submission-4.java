// 1 2 3 4 5 2
// brute force: O(n)
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1]; // opt at i, inclusively
        //   1 1 3 3
        // 0 1 
        
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++){
            int robSum = nums[i - 1] + dp[i - 2]; 
            int skipSum = dp[i - 1];  
            dp[i] = Math.max(robSum, skipSum);
        }

        return dp[dp.length - 1];


        
    }
}
