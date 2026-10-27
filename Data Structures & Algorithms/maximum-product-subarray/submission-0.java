class Solution {
    public int maxProduct(int[] nums) {
        // 维护以nums[i]结尾的 最小值和最大值
        int curMax = nums[0], curMin = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = curMax * nums[i];
            int b = curMin * nums[i];
            curMax = Math.max(nums[i], Math.max(a, b));
            curMin = Math.min(nums[i], Math.min(a, b));
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}
