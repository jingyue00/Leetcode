/**
 * Requirement: Given a linked list, determine if it has a cycle in it.
 * Solution: Use ListNode fast and slow to check equals
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
