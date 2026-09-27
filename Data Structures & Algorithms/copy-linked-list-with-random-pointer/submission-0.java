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
        Map<Node, Node> copyMap = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next){
            copyMap.put(cur, new Node(cur.val));
        }

        for (Node cur = head; cur != null; cur = cur.next){
            copyMap.get(cur).next = copyMap.get(cur.next);
            copyMap.get(cur).random = copyMap.get(cur.random);
        }

        return copyMap.get(head);
   }
}