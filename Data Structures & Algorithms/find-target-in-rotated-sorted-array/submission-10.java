class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        // Step 1: 找最小值下标
        int pivot = findMinIndex(nums);

        // Step 2: 决定在哪一段搜索
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            return binarySearch(nums, target, pivot, n - 1);   // 右段
        } else {
            return binarySearch(nums, target, 0, pivot - 1);   // 左段
        }
    }

    private int findMinIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {                      
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }                  
        }
        return hi;
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
