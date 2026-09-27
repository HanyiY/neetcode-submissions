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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (equalTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean equalTree(TreeNode one, TreeNode two){
        if (one == null && two == null) return true;
        if (one == null || two == null) return false;
        if (one.val != two.val) return false;
        boolean leftSame = equalTree(one.left, two.left);
        boolean rightSame = equalTree(one.right, two.right);
        return leftSame && rightSame;
    }
}
