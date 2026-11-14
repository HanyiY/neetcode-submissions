class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        while (i < n) {
            if (nums[i] < pivot) {
                res[left++] = nums[i++];
            }else{
                i++;
            }
        }

        while (j >= 0) {
            if (nums[j] > pivot) {
                res[right--] = nums[j--];
            }else{
                j--;
            }
        }

        while (left <= right) {
            res[left++] = pivot; 
        }

        return res;
    }
}
