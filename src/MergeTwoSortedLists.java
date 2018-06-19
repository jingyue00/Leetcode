/**
 * Solution: After consider whether l1, l2 equals null as the corner case. We create a dummy node.
 *      Use while loop to go through l1 and l2. if l1 or l2 equals null, let its val equals
 *      Integer.MAX_VALUE, since every time we only take the node with smaller value, so if
 *      the after we set the value of null node to maximum integer, we will not consider it again
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        } else if (l1  == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 <= val2) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
