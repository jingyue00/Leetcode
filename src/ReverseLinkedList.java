/**
 * Solution: for iteration each time we set next, and let head point to prev
 *      for recursion we build pointer from next to head, and remove pointer from head to next
 *      using equals null
 * Time Complexity: Iteration - O(n), Recursion - O(n)
 * Space Complexity: Iteration - O(1), Recursion - O(n)  The extra space comes from implicit stack
 *      space due to recursion. The recursion could go up to n levels deep.
 */
public class ReverseLinkedList {
    public ListNode reverseListIter(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
