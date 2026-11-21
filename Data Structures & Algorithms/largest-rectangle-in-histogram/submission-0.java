class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // record the index a bar can be extended to most
        int[] rightBound = new int[n];
        int[] leftBound = new int[n];
        rightBound[n - 1] = n - 1;
        leftBound[0] = 0;
        for (int i = 1; i < n; i++) {
            leftBound[i] = 0;
            for (int j = i - 1; j >= 0; j = leftBound[j] - 1) {
                if (heights[j] < heights[i]) {
                    leftBound[i] = j + 1;
                    break;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            rightBound[i] = n - 1;
            for (int j = i + 1; j < n; j = rightBound[j] + 1) {
                if (heights[j] < heights[i]) {
                    rightBound[i] = j - 1;
                    break;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max (maxArea, (rightBound[i] - leftBound[i] + 1) * heights[i]);
        }

        return maxArea;
    }
}
