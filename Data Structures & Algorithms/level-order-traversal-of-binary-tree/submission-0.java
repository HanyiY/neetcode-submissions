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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // BFS O(n)
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        // initialize
        q.offer(root);
        while (!q.isEmpty()){
            int levelLength = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < levelLength; i++){
                // expand
                TreeNode curNode = q.poll();
                cur.add(curNode.val);
                // generate
                if (curNode.left != null){
                    q.offer(curNode.left);
                }
                if (curNode.right != null){
                    q.offer(curNode.right);
                }
            }
            res.add(cur);
        }
        return res;
        
    }
}








