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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    // 一个null一个不是，结构不同
    if (p == null || q == null) return false;
    // 值不同
    if (p.val != q.val) return false;
    // 递归比较左右子树
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
