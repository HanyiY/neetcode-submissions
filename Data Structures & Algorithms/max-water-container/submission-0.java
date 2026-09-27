class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;
        while (left < right){
            int shorterL = Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, (right - left) * shorterL);
            if (heights[left] == shorterL){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
