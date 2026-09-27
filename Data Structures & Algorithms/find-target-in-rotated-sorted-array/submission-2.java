class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            // 判断哪半边是有序的
            if (nums[l] <= nums[m]) {
                // 左半边有序
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;  // target 在有序的左半边
                } else {
                    l = m + 1;  // target 在右半边
                }
            } else {
                // 右半边有序
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;  // target 在有序的右半边
                } else {
                    r = m - 1;  // target 在左半边
                }
            }
        }
        return -1;
    }
}
