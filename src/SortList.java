/**
 * Solution: In order to sort list in O(nlogn) time, we need to use MergeSort. Find middle of list,
 *      Cut them to left half and right half. And Merge two side in order.
 *      Important: use recursion we can boil down to a big case to smaller one.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode secHead = middle.next;
        middle.next = null;
        return mergeTwoList(sortList(head), sortList(secHead));
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode head, ListNode secHead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && secHead != null) {
            if (secHead.val < head.val) {
                cur.next = secHead;
                secHead = secHead.next;
            } else {
                cur.next = head;
                head = head.next;
            }
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
        } else if (secHead != null) {
            cur.next = secHead;
        }
        return dummy.next;
    }
}
