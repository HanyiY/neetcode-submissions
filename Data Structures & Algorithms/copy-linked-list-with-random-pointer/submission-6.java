/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)   return null;
        // old node -> new node
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node copyCur = dummy;
        Node cur = head;

        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            copyCur.next = newNode;
            copyCur = copyCur.next;
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node newNode = map.get(cur);
            newNode.random = map.get(cur.random);
            cur = cur.next;

        }

        return map.get(head);
    }
}
