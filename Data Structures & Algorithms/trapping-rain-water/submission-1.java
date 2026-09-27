class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int leftCurMax = height[0];
        int rightCurMax = height[n-1];
        int totalWaterTrapped = 0;
        for (int i = 1; i < n; i++){
            leftCurMax = Math.max(leftCurMax, height[i - 1]);
            leftMax[i] = leftCurMax;
        }
        for (int i = n-2; i > 0; i--){
            rightCurMax = Math.max(rightCurMax, height[i + 1]);
            rightMax[i] = rightCurMax;
        }

        for (int i = 1; i < n - 1; i++){
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (diff > 0)  totalWaterTrapped += diff; 
        }

        return totalWaterTrapped;
    }
}

// at i, amount of water = (min(leftMax, rightMax) - height[i])   must be positive
// we can scan and store leftMax[i] and right[max] first. Then O1 lookup to calculate
