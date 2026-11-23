/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if (node == null) return null;
        map.put(node, new Node(node.val));
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node clone = map.get(node);
        for (Node nei: node.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new Node(nei.val));
                dfs(nei, map);
            }
            clone.neighbors.add(map.get(nei));
        }
        return clone;
    }
}