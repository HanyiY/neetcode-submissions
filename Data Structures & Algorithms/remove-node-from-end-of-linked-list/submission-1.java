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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) size++;

        ListNode prev = dummy;
        for (int i = 0; i < size - n; i++) {   // 走 size-n 步,停在待删节点的前一个
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}
