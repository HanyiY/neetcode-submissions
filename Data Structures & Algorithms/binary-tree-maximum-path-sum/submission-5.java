/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = {Integer.MIN_VALUE};
        maxOneWaySum(root, res);
        return res[0];
    }

    private int maxOneWaySum(TreeNode root, int[] res) {
        if (root == null)   return 0;
        int leftMax = maxOneWaySum(root.left, res);
        int rightMax = maxOneWaySum(root.right, res);
        int curMax = Math.max(Math.max(leftMax + root.val, rightMax + root.val), 0);
        // curMax = Math.max (curMax, 0);
        res[0] = Math.max(res[0], leftMax + root.val + rightMax);
        return curMax;
    } 
}
