class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n]; // true if can jump from position i to end.
        // 1 2 0 1 0
        // f f f f t
        canJump[n - 1] = true;
        for (int i = n - 2; i >= 0; i--){
            for (int j = n - 1; j >= i; j--){
                if (nums[i] >= j - i && canJump[j]){
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];
    }
}
