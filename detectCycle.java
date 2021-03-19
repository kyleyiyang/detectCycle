/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle=false;
        do {
            if (fast==null || fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) isCycle=true;
        } while (fast!=slow);
        if (!isCycle) return null;
        slow=head;
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
