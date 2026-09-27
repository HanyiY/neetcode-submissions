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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrderRecord(root, k, res);
        return res.get(res.size() - 1);
    }

    private void inOrderRecord(TreeNode root, int k, List<Integer> res){
        if (root == null)   return;
        inOrderRecord(root.left, k, res);
        if (res.size() == k) return; // 必须在add前检查！！
        res.add(root.val);
        // if (res.size() == k) return; 不能加在这！！
        inOrderRecord(root.right, k, res);
    }
}
