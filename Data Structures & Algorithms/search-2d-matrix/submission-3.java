class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mm = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = mm - 1;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (matrix[m][0] == target) return true;
            else if (matrix[m][0] < target) l = m;
            else r = m - 1;
        }

        return search(matrix[l], target) || search(matrix[r], target);
    }

    private boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
