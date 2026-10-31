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

public class Codec {
    private static final String sep = ",";
    private static final String nullNode = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullNode).append(sep);
            return;
        }
        sb.append(root.val).append(sep);
        build(root.left, sb);
        build(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private int idx;
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(sep);
        idx = 0;
        return build2(tokens);
    }

    private TreeNode build2 (String[] tokens) {
        String token = tokens[idx++];          // 取当前 token，然后下标 +1
        if (token.equals(nullNode)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = build2(tokens);         // 先左
        node.right = build2(tokens);        // 后右
        return node;
    }
}
