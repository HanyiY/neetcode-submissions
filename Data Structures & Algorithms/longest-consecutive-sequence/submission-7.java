class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int lcs = 1;

        for (int i = 1; i < n; i++){
            if (nums[i - 1] + 1 == nums[i]){
                dp[i] = dp[i - 1] + 1;
            }else if (nums[i - 1] == nums[i]){
                dp[i] = dp[i - 1];
            }
            lcs = Math.max(lcs, dp[i]);
        }

        return lcs;
    }
}



// dp def: LCS end at i, inclusively.
// dp[i] = if 1 greater, dp[i - 1], dp[i-2], ... dp[0] + 1 OR 1 