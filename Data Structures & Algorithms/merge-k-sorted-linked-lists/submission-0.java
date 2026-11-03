/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode head: lists) {
            if (head != null) minHeap.offer(head);
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
            cur.next = minNode;
            cur = cur.next;
        }
        return dummy.next;
    }
}
