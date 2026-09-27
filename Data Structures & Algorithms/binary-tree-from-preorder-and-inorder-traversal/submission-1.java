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

public class Solution {
    int pre_idx = 0;  // 全局指针，指向preorder当前该取哪个根
    HashMap<Integer, Integer> indices = new HashMap<>();  // val -> inorder中的index
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 预处理：把inorder每个值的位置存进map，O(1)查找
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;  // 子树为空
        
        int root_val = preorder[pre_idx++];  // 取当前根，指针右移
        TreeNode root = new TreeNode(root_val);
        
        int mid = indices.get(root_val);  // 在inorder里找根的位置
        
        root.left  = dfs(preorder, l, mid - 1);   // 左子树
        root.right = dfs(preorder, mid + 1, r);   // 右子树
        
        return root;
    }
}