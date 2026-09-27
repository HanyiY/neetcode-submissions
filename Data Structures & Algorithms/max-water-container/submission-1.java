class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0, right = heights.length - 1;
        while (left < right){
            int lowerHeight = Math.min(heights[left], heights[right]);
            int cur = (right - left) * lowerHeight;
            max = Math.max(max, cur);
            if (heights[left] <= heights[right])    left++;
            else    right--;
        }
        return max;
    }
}

// two pointer: left, right: record water amount, move lower one.