/**
 * Solution: Have a dummy ndoe, let prev = dummy, cur = head. Then continue change each pair
 *      newHead = cur.next.next, prev.next = cur.next, cur.next = nextHead
 *      Then reset prev = cur, cur = nextHead
 *      Important: don't forget dummy.next head at the beginning and cur.next = nextHead
 *      during the loop.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextHead = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = nextHead;
            prev = cur;
            cur = nextHead;

        }
        return dummy.next;
    }
}
